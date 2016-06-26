package com.toin.work.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;
import com.toin.work.App;
import com.toin.work.Navigation;
import com.toin.work.R;
import com.toin.work.base.utils.DensityUtil;
import com.toin.work.base.utils.TUtil;
import com.toin.work.ui.setting.MineInfoActivity;
import com.toin.work.ui.setting.SettingActivity;
import com.toin.work.ui.workplace.WorkPlaceActivity;
import com.toin.work.widget.xcSlideView.XCSlideView;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by hb on 16/3/29.
 */
public abstract class BaseActivity<T extends BasePresenter, E extends BaseInterator> extends
        FragmentActivity {
    public T           mPresenter;
    public E           mInterator;
    public XCSlideView leftSlideView;

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();

    /**
     * 简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
     */
    public abstract void initPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //全部禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        //        小米沉浸式状态栏
        //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        //            //状态栏透明 需要在创建SystemBarTintManager 之前调用。
        //            setTranslucentStatus(true);
        //        }
        //        mTintManager = new SystemBarTintManager(this);
        //        mTintManager.setStatusBarTintEnabled(true);
        //        //使StatusBarTintView 和 actionbar的颜色保持一致，风格统一。
        //        mTintManager.setStatusBarTintResource(R.color.white);
        //        // 设置状态栏的文字颜色
        //        mTintManager.setStatusBarDarkMode(true, this);
        setContentView(initLayout());
        ButterKnife.bind(this);
        mPresenter = TUtil.getT(this, 0);
        mInterator = TUtil.getT(this, 1);
        setOnClick(R.id.btn_back);
        View mineView = LayoutInflater.from(this).inflate(R.layout.activity_mine, null);
        leftSlideView = XCSlideView.create(this, XCSlideView.Positon.LEFT);
        leftSlideView.setMenuView(this, mineView);
        leftSlideView.setMenuWidth(DensityUtil.getScreenWidthAndHeight(this)[0] * 7 / 9);
        leftSlideView.findViewById(R.id.tv_workplace).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.goPage(BaseActivity.this, WorkPlaceActivity.class);
                        finish();
                    }
                });
        leftSlideView.findViewById(R.id.img_header).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.goPage(BaseActivity.this, MineInfoActivity.class);
            }
        });

        leftSlideView.findViewById(R.id.tv_setting).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.goPage(BaseActivity.this, SettingActivity.class);
            }
        });
        initView();
        initPresenter();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        ButterKnife.unbind(this);
        /** 内存泄露监测 */
        RefWatcher refWatcher = App.getRefWatcher();
        refWatcher.watch(this);
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
        View view = findViewById(viewId);
        return (T) view;
    }

    /**
     * 通过控件的Id获取对应的控件
     *
     * @param viewId
     * @return
     */
    @SuppressWarnings("unchecked")
    protected final <T extends View> T findView(View view, int viewId) {
        View tView = view.findViewById(viewId);
        return (T) tView;
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
            setOnClick(this.<View> findView(i));
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

    @Override
    protected void onResume() {
        super.onResume();
        //友盟统计
        //MobclickAgent.onResume(this); //统计时长
        //极光推送统计
        //JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //友盟统计
        //MobclickAgent.onPause(this);
        //极光推送统计
        //JPushInterface.onPause(this);
    }

    /**
     * @param fragmentClass
     * @param tag 唯一标识fragment，一般用fragment类名即可
     * @param argument 要给fragment传递的参数
     */
    protected final void showFragment(Class<? extends BaseFragment> fragmentClass, String tag,
                                      Bundle argument) {
        try {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            List<Fragment> fragments = fm.getFragments();
            if (fragments != null) {
                for (Fragment item : fragments) {
                    ft.hide(item);
                }
            }
            Fragment pf = fm.findFragmentByTag(tag);
            if (pf != null) {
                ft.show(pf);
            } else {
                Fragment fragment = fragmentClass.newInstance();
                if (argument != null) {
                    fragment.setArguments(argument);
                }
                // ft.add(R.id.fragment_container, fragment, tag);
            }
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
