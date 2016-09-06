package com.toin.glp.tools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import java.util.HashMap;

public class STTabManager {

    private final FragmentActivity         mActivity;
    private final int                      mContainerId;
    private final HashMap<String, TabInfo> mTabs = new HashMap<String, TabInfo>();
    TabInfo                                mLastTab;

    static final class TabInfo {
        private final String   tag;
        private final Class<?> clss;
        private final Bundle   args;
        private Fragment       fragment;

        TabInfo(String _tag, Class<?> _class, Bundle _args) {
            tag = _tag;
            clss = _class;
            args = _args;
        }
    }

    public STTabManager(FragmentActivity activity, int containerId) {
        mActivity = activity;
        mContainerId = containerId;
    }

    public void addTab(String tag, Class<?> cls) {
        addTab(tag, cls, null);
    }

    public void addTab(String tag, Class<?> cls, Bundle args) {
        mTabs.put(tag, new TabInfo(tag, cls, args));
    }

    public void setTabSelection(String tag) {
        if (mTabs.containsKey(tag)) {
            final TabInfo newTab = mTabs.get(tag);
            if (mLastTab != newTab) {
                changeTab(newTab, tag);
            }
        }
    }

    private void changeTab(TabInfo newTab, String tabId) {
        FragmentTransaction fTransaction = mActivity.getSupportFragmentManager().beginTransaction();
        if (mLastTab != null) {
            if (mLastTab.fragment != null) {
                fTransaction.hide(mLastTab.fragment);
            }
        }

        if (newTab != null) {
            if (newTab.fragment == null) {
                newTab.fragment = Fragment.instantiate(mActivity, newTab.clss.getName(),
                        newTab.args);
                fTransaction.add(mContainerId, newTab.fragment, newTab.tag);
            } else {
                fTransaction.show(newTab.fragment);
            }
        }

        mLastTab = newTab;
        fTransaction.commitAllowingStateLoss();
        mActivity.getSupportFragmentManager().executePendingTransactions();
    }
}
