package com.toin.glp.ui.message;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.toin.glp.App;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.widget.adapter.ContentViewPagerAdater;

import butterknife.Bind;
import cn.bingoogolapple.bgabanner.BGAViewPager;

/**
 * 消息 Created by hb on 16/6/26.
 */
public class MessageFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener,
        View.OnClickListener {
    @Bind(R.id.title_group)
    RadioGroup   mRadioGroup;
    @Bind(R.id.viewpager)
    BGAViewPager mViewPager;
    @Bind(R.id.ll_go_login)
    LinearLayout mLinearLayout;

    @Override
    protected int initLayout() {
        return R.layout.activity_message;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.tv_login);
        mRadioGroup.setOnCheckedChangeListener(this);
        if (TextUtils.isEmpty(App.token)) {
            mViewPager.setVisibility(View.GONE);
            mLinearLayout.setVisibility(View.VISIBLE);
        } else {
            setUpViewPager();
        }
    }

    private void setUpViewPager() {
        mViewPager.setAllowUserScrollable(true);
        Class[] fragments = new Class[] { MessageNotReadFragment.class, MessageReadFragment.class };
        mViewPager.setAdapter(new ContentViewPagerAdater(getFragmentManager(), getActivity(),
                fragments));
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mRadioGroup.check(R.id.rb_msg_not_read);
                } else if (position == 1) {
                    mRadioGroup.check(R.id.rb_msg_read);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_msg_not_read://未读
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.rb_msg_read://已读
                mViewPager.setCurrentItem(1, false);
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                Navigation.goLoginPage(getActivity());
                break;
        }
    }

}
