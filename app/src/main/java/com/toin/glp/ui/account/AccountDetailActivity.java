package com.toin.glp.ui.account;

import android.view.View;
import android.widget.TextView;

import com.squareup.okhttp.RequestBody;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.models.account.AccountsDetailModel;
import com.toin.glp.models.account.AccountsDetailModel.AccountDetailModel;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 还款计划 Created by hb on 16/9/14.
 */
public class AccountDetailActivity extends BaseActivity implements View.OnClickListener {
    public static final String EXTRA_ID = "id";
    private String             id;
    @Bind(R.id.tv_money)
    TextView                   totalTv;        //账单总额
    @Bind(R.id.tv_payment)
    TextView                   paymentTv;      //还款周期
    @Bind(R.id.tv_repay_money)
    TextView                   repayMoneyTv;   //借款金额  
    @Bind(R.id.tv_contract_time)
    TextView                   contractTimeTv; //合同时间
    @Bind(R.id.tv_repay_way)
    TextView                   repayWayTv;     //还款方式
    @Bind(R.id.tv_all_interest)
    TextView                   allInterestTv;  //总利息

    @Override
    protected int initLayout() {
        return R.layout.activity_account_detail;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.rl_repay_plan, R.id.btn_back);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_ACCOUNT_DETAIL);
        id = getIntent().getStringExtra(EXTRA_ID);
        httpGetAccountDetail();
    }

    private void httpGetAccountDetail() {
        showProgress("加载中...");
        Map<String, Object> params = new HashMap<>();
        params.put("tranCode", "queryPutoutApplyDetail");
        params.put("APPLYNO", id);
        RequestBody body = ApiFactory.get_request(params);
        ApiFactory factory = new ApiFactory();
        Subscription s = factory.get_financing().getBaseApiSingleton().getAccountDetail(body)
                .map(new Func1<AccountsDetailModel, AccountDetailModel>() {
                    @Override
                    public AccountDetailModel call(AccountsDetailModel model) {
                        return model.getResponseBody();
                    }
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AccountDetailModel>() {
                    @Override
                    public void onCompleted() {
                        hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideProgress();
                    }

                    @Override
                    public void onNext(AccountDetailModel accountDetailModel) {
                        hideProgress();
                        setAccountDetailInfo(accountDetailModel);
                    }
                });
        addSubscription(s);
    }

    private void setAccountDetailInfo(AccountDetailModel detailModel) {
        totalTv.setText(detailModel.getPUTOUTAMT());
        paymentTv.setText("该笔额度将分" + detailModel.getPERIOD() + "期还完");
        repayMoneyTv.setText(detailModel.getPUTOUTAMT());
        contractTimeTv.setText(detailModel.getBEGINDATE() + "-" + detailModel.getENDDATE());
        repayWayTv.setText(detailModel.getDEDUCTINTTYPENAME());
        allInterestTv.setText(detailModel.getTOTALAMOUNT());
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_repay_plan:
                //还款计划
                Navigation.goRepayPlanPage(this, id);
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
