package com.toin.glp.ui.account;

import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.okhttp.RequestBody;
import com.toin.glp.App;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.base.utils.TypeTranUtils;
import com.toin.glp.models.account.AccountsModel.ResponseBodyEntity.AccountModel;
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
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 账单 Created by hb on 16/6/25.
 */
public class AccountFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout                  mSwipeRefreshLayout;
    @Bind(R.id.autoload_listview)
    AutoLoadListView                    mAutoListView;
    @Bind(R.id.listView)
    View                                frameLayout;
    @Bind(R.id.ll_go_login)
    LinearLayout                        mLinearLayout;
    @Bind(R.id.swipe_refresh_empty)
    SwipeRefreshLayout                  mEmptySwipeRefreshLayout = null;
    @Bind(R.id.img_empty)
    ImageView                           emptyImg                 = null;
    private List<AccountModel>          dataList                 = new ArrayList<>();
    private CommonAdapter<AccountModel> mAdapter                 = null;

    private int                         count                    = 0;
    private int                         pageSize                 = 10;
    private int                         pageIndex                = 1;

    @Override
    protected int initLayout() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.tv_login);
        if (TextUtils.isEmpty(App.token)) {
            frameLayout.setVisibility(View.GONE);
            mLinearLayout.setVisibility(View.VISIBLE);
        } else {
            mLinearLayout.setVisibility(View.GONE);
            //初始化控件
            GlpUtils.initRefresh(mSwipeRefreshLayout, mAutoListView, new ZmRefreshListener() {
                @Override
                public void onRefresh() {
                    pageIndex = 1;
                    httpGetAccountList();
                }

                @Override
                public void onLoadNext() {
                    pageIndex++;
                    showProgress("加载中...");
                    httpGetAccountList();
                }
            }, mEmptySwipeRefreshLayout);
            emptyImg.setImageDrawable(getResources().getDrawable(R.mipmap.blank2));
            mAdapter = new CommonAdapter<AccountModel>(getActivity(), dataList,
                    R.layout.item_account) {
                @Override
                public void convert(ViewHolder helper, AccountModel item) {
                    helper.setText(R.id.tv_time, item.getMATURITYDATE());
                    helper.setText(R.id.tv_money, item.getBUSINESSSUM());
                    TextView statusTv = helper.getView(R.id.tv_status);
                    //1:逾期,2:正常结清,3:提前结清,4:逾期结清
                    GradientDrawable statusShape = (GradientDrawable) statusTv.getBackground();
                    if (item.getLOANSTATUS().equals("2")) {
                        statusShape.setColor(ContextCompat.getColor(getActivity(),
                                R.color.gray_hint));
                    } else if (item.getLOANSTATUS().equals("3")) {
                        statusShape.setColor(ContextCompat.getColor(getActivity(),
                                R.color.account_green));
                    } else if (item.getLOANSTATUS().equals("1") || item.getLOANSTATUS().equals("4")) {
                        statusShape.setColor(ContextCompat.getColor(getActivity(),
                                R.color.account_red));
                    } else {
                        statusShape.setColor(ContextCompat.getColor(getActivity(),
                                R.color.account_green));
                    }
                    helper.setText(R.id.tv_status, item.getLOANSTATUSDESC());
                }
            };
            mAutoListView.setAdapter(mAdapter);
            mAutoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AccountModel model = dataList.get(position);
                    Navigation.goAccountDetailPage(getActivity(), model.getPUTOUTNO());
                }
            });
        }
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TAB_TAG_ACCOUNT);
        if (!TextUtils.isEmpty(App.token)) {
            showProgress("加载中...");
            httpGetAccountList();
        }
    }

    private void httpGetAccountList() {
        Map<String, Object> params = new HashMap<>();
        params.put("tranCode", "queryLoanList");
        params.put("PAGENO", pageIndex);
        params.put("PAGEMAXNUM", pageSize);
        params.put("PRDCODE", "");
        params.put("LOANSTATUS", "");
        RequestBody body = ApiFactory.get_request(params);
        ApiFactory factory = new ApiFactory();
        Subscription s = factory
                .get_financing()
                .getBaseApiSingleton()
                .getAccountList(body)
                .map(accountsModel -> {
                    count = TypeTranUtils.str2Int(accountsModel.getResponseBody().getDatasetSize());
                    return accountsModel.getResponseBody().getData();
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<List<AccountModel>>() {
                    @Override
                    public void onCompleted() {
                        hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        hideProgress();
                    }

                    @Override
                    public void get_model(List<AccountModel> data) {
                        hideProgresses();
                        if (data != null) {
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
                        }
                    }
                });
        addSubscription(s);
    }

    private void hideProgresses() {
        hideProgress();
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        if (mEmptySwipeRefreshLayout.isRefreshing()) {
            mEmptySwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void initPresenter() {

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
