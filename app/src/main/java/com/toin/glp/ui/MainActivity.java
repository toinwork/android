package com.toin.glp.ui;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.base.utils.T;
import com.toin.glp.tools.STTabManager;
import com.toin.glp.ui.account.AccountFragment;
import com.toin.glp.ui.message.MessageFragment;
import com.toin.glp.ui.mine.MineFragment;
import com.toin.glp.widget.FlowRadioGroup;

import java.util.Date;

import butterknife.Bind;

/**
 * Created by hb on 16/4/6.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.rg_action_bar_bottom)
    FlowRadioGroup       mRadioGroup;
    @Bind(R.id.tv_message_count)
    ImageView            messageSign;
    private STTabManager tabManager    = null;
    private long         mLastBackTime = 0;
    private long         TIME_DIFF     = 2 * 1000;

    public static int    msgCount      = 0;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.rb_account, R.id.rb_message, R.id.rb_mine);
        tabManager = new STTabManager(this, android.R.id.tabcontent);
        tabManager.addTab(StringUtils.TAB_TAG_ACCOUNT, AccountFragment.class);
        tabManager.addTab(StringUtils.TAB_TAG_MESSAGE, MessageFragment.class);
        tabManager.addTab(StringUtils.TAB_TAG_MINE, MineFragment.class);
        checkedMain();
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        int margin = this.getWindowManager().getDefaultDisplay().getWidth() / 6;
        lp.setMargins(margin + 10, 10, 0, 0);
        messageSign.setLayoutParams(lp);
    }

    @Override
    protected void initData() {

    }

    private void checkedMain() {
        tabManager.setTabSelection(StringUtils.TAB_TAG_ACCOUNT);
        RadioButton button = (RadioButton) mRadioGroup.findViewById(R.id.rb_account);
        button.setChecked(true);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long now = new Date().getTime();
            if (now - mLastBackTime < TIME_DIFF) {
                return super.onKeyDown(keyCode, event);
            } else {
                mLastBackTime = now;
                T.showShort("再按一次返回键退出");
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_account:
                tabManager.setTabSelection(StringUtils.TAB_TAG_ACCOUNT);
                break;
            case R.id.rb_message:
                tabManager.setTabSelection(StringUtils.TAB_TAG_MESSAGE);
                break;
            case R.id.rb_mine:
                //                if (Navigation.checkLogin(this)) {
                tabManager.setTabSelection(StringUtils.TAB_TAG_MINE);
                //                } else {
                //                    checkedMain();
                //                }
                break;
            default:
                break;
        }
    }

}
