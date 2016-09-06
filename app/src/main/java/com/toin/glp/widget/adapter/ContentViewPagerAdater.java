package com.toin.glp.widget.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hb on 16/6/29.
 */
public class ContentViewPagerAdater extends FragmentPagerAdapter {
    private Class[] mFragments;
    private Context mContext;

    public ContentViewPagerAdater(FragmentManager fm, Context context, Class[] mFragments) {
        super(fm);
        mContext = context;
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return Fragment.instantiate(mContext, mFragments[position].getName());
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }
}
