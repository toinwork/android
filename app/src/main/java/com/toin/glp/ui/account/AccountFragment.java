package com.toin.glp.ui.account;

import android.support.v4.widget.SwipeRefreshLayout;

import com.toin.glp.R;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.base.utils.T;
import com.toin.glp.utils.GlpUtils;
import com.toin.glp.widget.ZmRefreshListener;
import com.toin.glp.widget.adapter.CommonAdapter;
import com.toin.glp.widget.adapter.ViewHolder;
import com.toin.glp.widget.autoloadListView.AutoLoadListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 账单 Created by hb on 16/6/25.
 */
public class AccountFragment extends BaseFragment {

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout            mSwipeRefreshLayout;
    @Bind(R.id.autoload_listview)
    AutoLoadListView              mAutoListView;
    private List<String>          dataList = new ArrayList<>();
    private CommonAdapter<String> mAdapter = null;

    @Override
    protected int initLayout() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initView() {
        //初始化控件
        GlpUtils.initRefresh(mSwipeRefreshLayout, mAutoListView, new ZmRefreshListener() {
            @Override
            public void onRefresh() {
                T.showShort("onRefresh");
            }

            @Override
            public void onLoadNext() {
                T.showShort("onLoadNext");
            }
        });
        mAdapter = new CommonAdapter<String>(getActivity(), dataList, R.layout.item_choice) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_money, item);
            }
        };
        mAutoListView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        setActionTitle("账单");
        for (int i = 0; i < 10; i++) {
            dataList.add("item" + i);
        }
        mAdapter.notifyDataSetChanged();
    }

}
