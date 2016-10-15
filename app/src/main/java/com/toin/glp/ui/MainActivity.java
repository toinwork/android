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
import com.toin.glp.ui.home.HomeFragment;
import com.toin.glp.ui.message.MessageFragment;
import com.toin.glp.ui.mine.MineFragment;
import com.toin.glp.widget.FlowRadioGroup;

import java.util.Date;

import butterknife.Bind;

/**
 * 主页 Created by hb on 16/4/6.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private String       TAB_HOME      = StringUtils.TAB_TAG_HOME;
    private String       TAB_ACCOUNT   = StringUtils.TAB_TAG_ACCOUNT;
    private String       TAB_MESSAGE   = StringUtils.TAB_TAG_MESSAGE;
    private String       TAB_MINE      = StringUtils.TAB_TAG_MINE;
    @Bind(R.id.rg_action_bar_bottom)
    FlowRadioGroup       mRadioGroup;
    @Bind(R.id.tv_message_count)
    ImageView            messageSign;
    private STTabManager tabManager    = null;
    private long         mLastBackTime = 0;
    private long         TIME_DIFF     = 2 * 1000;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.rb_home, R.id.rb_account, R.id.rb_message, R.id.rb_mine);
        tabManager = new STTabManager(this, android.R.id.tabcontent);
        tabManager.addTab(TAB_HOME, HomeFragment.class);
        tabManager.addTab(TAB_ACCOUNT, AccountFragment.class);
        tabManager.addTab(TAB_MESSAGE, MessageFragment.class);
        tabManager.addTab(TAB_MINE, MineFragment.class);
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
        tabManager.setTabSelection(TAB_HOME);
        RadioButton button = (RadioButton) mRadioGroup.findViewById(R.id.rb_home);
        button.setChecked(true);
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
            case R.id.rb_home:
                tabManager.setTabSelection(TAB_HOME);
                break;
            case R.id.rb_account:
                tabManager.setTabSelection(TAB_ACCOUNT);
                break;
            case R.id.rb_message:
                tabManager.setTabSelection(TAB_MESSAGE);
                break;
            case R.id.rb_mine:
                tabManager.setTabSelection(TAB_MINE);
                break;
            default:
                break;
        }
    }

}
