package com.toin.glp.ui.mine;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.toin.glp.App;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.base.utils.T;
import com.toin.glp.models.BaseResult;

import java.util.Map;

import butterknife.Bind;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 反馈 Created by hb on 16/6/26.
 */
public class FeedbackActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.et_content)
    EditText contentEt;

    @Override
    protected int initLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back, R.id.btn_commit);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_FEEDBACK);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_commit:
                String content = contentEt.getText().toString().trim();
                if (TextUtils.isEmpty(content)) {
                    T.showShort("反馈内容不能为空");
                    return;
                }
                showProgress("反馈中...");
                ApiFactory factory = new ApiFactory();
                Map<String, Object> params = ApiFactory.get_base_map();
                params.put("service", ApiName.MEMBER_FEEDBACK);
                params.put("partner_id", "188888888");
                params.put("token", App.token);
                params.put("content", content);
                Subscription s = factory.get_weijin().getBaseApiSingleton().feedback(params)
                        .map(baseResult -> {
                            return baseResult;
                        }).subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new BaseSubscriber<BaseResult>() {
                            @Override
                            public void onCompleted() {
                                hideProgress();
                            }

                            @Override
                            public void onError(Throwable e) {
                                hideProgress();
                                super.onError(e);
                            }

                            @Override
                            public void get_model(BaseResult result) {
                                if (result.is_success.equals("T")) {
                                    hideProgress();
                                    T.showShort("反馈成功");
                                    finish();
                                } else {
                                    T.showShort(result.getError_message());
                                }
                            }
                        });
                addSubscription(s);
                break;
        }
    }
}
