package com.toin.work.ui.message;

import android.view.View;
import android.widget.RadioGroup;

import com.toin.work.R;
import com.toin.work.base.BaseExitActivity;

import butterknife.Bind;

/**
 * 消息 Created by hb on 16/6/26.
 */
public class MessageActivity extends BaseExitActivity implements RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.title_group)
    RadioGroup mRadioGroup;

    @Override
    protected int initLayout() {
        return R.layout.activity_message;
    }

    @Override
    protected void initView() {
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                if (!leftSlideView.isShow()) {
                    leftSlideView.show();
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_msg_not_read://未读
                showFragment(MessageNotReadFragment.class, "message_not_read", null);
                break;
            case R.id.rb_msg_read://已读
                showFragment(MessageReadFragment.class, "message_read", null);
                break;
        }
    }
}
