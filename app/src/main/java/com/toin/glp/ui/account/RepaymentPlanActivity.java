package com.toin.glp.ui.account;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.okhttp.RequestBody;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.base.BaseExitActivity;
import com.toin.glp.base.utils.DensityUtil;
import com.toin.glp.models.account.RepayPlanModel.ResponseBodyEntity.PlanModel;
import com.toin.glp.utils.GlpUtils;
import com.toin.glp.widget.ZmRefreshListener;
import com.toin.glp.widget.adapter.CommonAdapter;
import com.toin.glp.widget.adapter.ViewHolder;
import com.toin.glp.widget.autoloadListView.AutoLoadListView;
import com.toin.glp.widget.autoloadListView.LoadingFooter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 还款计划 Created by hb on 16/9/14.
 */
public class RepaymentPlanActivity extends BaseExitActivity implements View.OnClickListener {
    public static final String       EXTRA_ID  = "id";
    private String                   id;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout               mSwipeRefreshLayout;
    @Bind(R.id.autoload_listview)
    AutoLoadListView                 mAutoListView;

    private List<PlanModel>          dataList  = new ArrayList<>();
    private CommonAdapter<PlanModel> mAdapter  = null;

    private int                      count     = 0;
    private int                      pageSize  = 10;
    private int                      pageIndex = 1;

    @Override
    protected int initLayout() {
        return R.layout.activity_repay_plan;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back);
        GlpUtils.initRefresh(mSwipeRefreshLayout, mAutoListView, new ZmRefreshListener() {
            @Override
            public void onLoadNext() {
                pageIndex++;
                httpRepayPlan();
            }

            @Override
            public void onRefresh() {
                pageIndex = 1;
                httpRepayPlan();
            }
        });
        mAdapter = new CommonAdapter<PlanModel>(this, dataList, R.layout.item_repay_plan) {
            @Override
            public void convert(ViewHolder helper, PlanModel item) {
                View line1 = helper.getView(R.id.line1);
                View line2 = helper.getView(R.id.line2);
                int position = helper.getPosition();
                TextView benqiTv = helper.getView(R.id.tv_benqi);
                int marginTop = DensityUtil.dip2px(RepaymentPlanActivity.this, 10);
                if (position == 0) {
                    benqiTv.setVisibility(View.VISIBLE);
                    line1.setVisibility(View.VISIBLE);
                    line2.setVisibility(View.VISIBLE);
                    LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) line1
                            .getLayoutParams();
                    lp.setMargins(0, marginTop, 0, 0);
                    line1.setLayoutParams(lp);
                    lp = (LinearLayout.LayoutParams) line2.getLayoutParams();
                    lp.setMargins(0, 0, 0, marginTop);
                    line2.setLayoutParams(lp);
                } else {
                    if (position == 1) {
                        line1.setVisibility(View.VISIBLE);
                    } else {
                        line1.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) line1
                                .getLayoutParams();
                        lp.setMargins(marginTop, 0, 0, 0);
                        line1.setLayoutParams(lp);
                    }
                    if (position == count - 1) {
                        line2.setVisibility(View.VISIBLE);
                    } else {
                        line2.setVisibility(View.GONE);
                    }
                    benqiTv.setVisibility(View.GONE);
                }
                helper.setText(R.id.tv_time, item.getPAYDATE());
                helper.setText(R.id.tv_money, item.getTOTALAMOUNT());
                helper.setText(R.id.tv_interest, "含利息" + item.getPAYINTEAMT());
            }
        };
        mAutoListView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_REPAY_PLAN);
        id = getIntent().getStringExtra(EXTRA_ID);
        httpRepayPlan();
    }

    private void httpRepayPlan() {
        Map<String, Object> params = new HashMap<>();
        params.put("tranCode", "repayPlan");
        params.put("PAGENO", pageIndex);
        params.put("PAGEMAXNUM", pageSize);
        params.put("APPLYNO", id);
        RequestBody body = ApiFactory.get_request(params);
        ApiFactory factory = new ApiFactory();
        Subscription s = factory.get_financing().getBaseApiSingleton().getRepayPlan(body)
                .map(model -> {
                    count = model.getResponseBody().getSUMCOUNT();
                    return model.getResponseBody().getPAYMENTLIST();
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<PlanModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<PlanModel> data) {
                        if (pageIndex == 1) {
                            dataList.clear();
                        }
                        dataList.addAll(data);
                        mAdapter.notifyDataSetChanged();
                        if (dataList.size() >= count) {
                            mAutoListView.setState(LoadingFooter.State.TheEnd);
                        } else {
                            mAutoListView.setState(LoadingFooter.State.Idle);
                        }
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
        addSubscription(s);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
