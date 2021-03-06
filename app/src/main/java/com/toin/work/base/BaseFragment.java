package com.toin.work.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;
import com.toin.work.App;
import com.toin.work.R;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseFragment extends Fragment {

    private CompositeSubscription mCompositeSubscription;

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View headerView = inflater.inflate(initLayout(), container, false);
        ButterKnife.bind(this, headerView);
        return headerView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        /** 内存泄露监测 */
        RefWatcher refWatcher = App.getRefWatcher();
        refWatcher.watch(this);
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    /**
     * 设置导航栏标题
     * 
     * @param title
     */
    protected final void setActionTitle(String title) {
        TextView titleTv = findView(R.id.tv_action_title);
        if (titleTv != null && !TextUtils.isEmpty(title)) {
            titleTv.setText(title);
        }
    }

    /**
     * 设置导航栏标题
     * 
     * @param resId
     */
    protected final void setActionTitle(int resId) {
        String title = getResources().getString(resId);
        setActionTitle(title);
    }

    /**
     * 通过控件的Id获取对应的控件
     * 
     * @param viewId
     * @return
     */
    @SuppressWarnings("unchecked")
    protected final <T extends View> T findView(int viewId) {
        View rView = getView().findViewById(viewId);
        return (T) rView;
    }

    /**
     * 通过控件的Id和控件所在布局获取对应的控件
     * 
     * @param view
     * @param viewId
     * @return
     */
    @SuppressWarnings("unchecked")
    protected final <T extends View> T findView(View view, int viewId) {
        View rView = view.findViewById(viewId);
        return (T) rView;
    }

    /**
     * 给id设置监听
     * 
     * @param ids
     */
    protected final void setOnClick(int... ids) {
        if (ids == null) {
            return;
        }
        for (int i : ids) {
            findView(i).setOnClickListener((OnClickListener) this);
        }
    }

    /**
     * 给view设置监听
     * 
     * @param params
     */
    protected final void setOnClick(View... params) {
        if (params == null) {
            return;
        }
        for (View view : params) {
            if (view != null && this instanceof OnClickListener) {
                view.setOnClickListener((OnClickListener) this);
            }
        }
    }

    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

    public void setRequestDataRefresh(final SwipeRefreshLayout mSwipeRefresh) {
        if (mSwipeRefresh == null) {
            return;
        }
        // 防止刷新消失太快，让子弹飞一会儿.
        // 防止刷新消失太快，让子弹飞一会儿.
        mSwipeRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mSwipeRefresh != null) {
                    mSwipeRefresh.setRefreshing(false);
                }
            }
        },1000);
    }

}
