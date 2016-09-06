package com.toin.glp.ui.message;

import android.support.v4.widget.SwipeRefreshLayout;

import com.toin.glp.R;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.widget.adapter.CommonAdapter;

/**
 * 未读 Created by hb on 16/6/26.
 */
public class MessageNotReadFragment extends BaseFragment {

    SwipeRefreshLayout            mSwipeRefreshLayout = null;
    private CommonAdapter<String> mAdapter            = null;

    @Override
    protected int initLayout() {
        return R.layout.fragment_msg_not_read;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
