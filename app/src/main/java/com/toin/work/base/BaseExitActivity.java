package com.toin.work.base;

import android.view.View;

import com.toin.work.R;

/**
 * Created by hb on 16/6/25.
 */
public abstract class BaseExitActivity extends BaseActivity implements View.OnClickListener{

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
}
