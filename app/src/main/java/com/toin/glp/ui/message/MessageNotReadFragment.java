package com.toin.glp.ui.message;

import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.okhttp.RequestBody;
import com.toin.glp.R;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.base.utils.DensityUtil;
import com.toin.glp.base.utils.T;
import com.toin.glp.base.utils.TypeTranUtils;
import com.toin.glp.models.account.MessageListModel;
import com.toin.glp.models.account.MessageModel;
import com.toin.glp.models.account.SetMessageModel.ResponseBodyEntity;
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
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 未读 Created by hb on 16/6/26.
 */
public class MessageNotReadFragment extends BaseFragment {

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout                  mSwipeRefreshLayout      = null;
    @Bind(R.id.autoload_listview)
    AutoLoadListView                    mAutoLoadListView        = null;
    @Bind(R.id.swipe_refresh_empty)
    SwipeRefreshLayout                  mEmptySwipeRefreshLayout = null;
    @Bind(R.id.img_empty)
    ImageView                           emptyImg                 = null;
    private List<MessageModel>          dataList                 = new ArrayList<>();
    private CommonAdapter<MessageModel> mAdapter                 = null;

    private int                         count                    = 0;
    private int                         pageSize                 = 20;
    private int                         pageIndex                = 1;

    @Override
    protected int initLayout() {
        return R.layout.fragment_msg_not_read;
    }

    @Override
    protected void initView() {
        GlpUtils.initRefresh(mSwipeRefreshLayout, mAutoLoadListView, new ZmRefreshListener() {
            @Override
            public void onLoadNext() {
                pageIndex++;
                httpGetMessageList();
            }

            @Override
            public void onRefresh() {
                pageIndex = 1;
                httpGetMessageList();
            }
        }, mEmptySwipeRefreshLayout);
        emptyImg.setImageDrawable(getResources().getDrawable(R.mipmap.blank4));
        mAdapter = new CommonAdapter<MessageModel>(getActivity(), dataList, R.layout.item_message) {
            @Override
            public void convert(ViewHolder helper, MessageModel item) {
                TextView contentTv = helper.getView(R.id.tv_content);
                TextView redPointTv = helper.getView(R.id.tv_red_point);
                if (item.getSTATUS().equals("01")) {//未读
                    contentTv.setTextColor(getResources().getColor(R.color.black));
                    redPointTv.setVisibility(View.VISIBLE);
                } else {
                    redPointTv.setVisibility(View.GONE);
                    contentTv.setTextColor(getResources().getColor(R.color.gray));
                }
                TextView timeTv = helper.getView(R.id.tv_time);
                contentTv.setText(item.getDETAIL());
                int margin = DensityUtil.dip2px(getActivity(), 10);
                RelativeLayout messageRl = helper.getView(R.id.rl_message);
                messageRl.setOnClickListener(new View.OnClickListener() {
                    boolean flag = true;

                    @Override
                    public void onClick(View v) {
                        if (flag) {
                            flag = false;
                            contentTv.setEllipsize(null);//展开
                            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            lp.setMargins(margin, 0, margin, margin);
                            contentTv.setLayoutParams(lp);
                            lp = new RelativeLayout.LayoutParams(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                            lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                            lp.setMargins(0, margin, margin, 0);
                            timeTv.setLayoutParams(lp);
                        } else {
                            flag = true;
                            contentTv.setEllipsize(TextUtils.TruncateAt.END);//收缩
                            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            lp.setMargins(margin, 0, margin, 0);
                            lp.addRule(RelativeLayout.LEFT_OF, R.id.tv_time);
                            contentTv.setLayoutParams(lp);
                            lp = new RelativeLayout.LayoutParams(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                            lp.setMargins(0, margin, margin, 0);
                            timeTv.setLayoutParams(lp);
                        }
                        contentTv.setSingleLine(flag);
                        if (item.getSTATUS().equals("01")) {
                            redPointTv.setVisibility(View.GONE);
                            httpSetMessageRead(item.getID(), contentTv);
                        }
                    }
                });
                helper.setText(R.id.tv_time, item.getINPUTDATE());
            }
        };
        mAutoLoadListView.setAdapter(mAdapter);
    }

    private void httpSetMessageRead(String id, TextView contentTv) {
        Map<String, Object> params = new HashMap<>();
        params.put("tranCode", "changeInfoStatus");
        params.put("ID", id);
        RequestBody body = ApiFactory.get_request(params);
        ApiFactory factory = new ApiFactory();
        Subscription s = factory.get_financing().getBaseApiSingleton().setMessageRead(body)
                .map(result -> result.getResponseBody()).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBodyEntity>() {
                    @Override
                    public void onCompleted() {
                        hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideProgress();
                    }

                    @Override
                    public void onNext(ResponseBodyEntity data) {
                        hideProgress();
                        if (!data.getRESULTCODE().equals("000000")) {
                            T.showShort(data.getRESULTMSG());
                            return;
                        }
                        if (data.getSTATUS().equals("02")) {//已读
                            contentTv.setTextColor(getResources().getColor(R.color.gray));
                        }
                    }
                });
        addSubscription(s);
    }

    @Override
    protected void initData() {
        httpGetMessageList();
    }

    private void httpGetMessageList() {
        Map<String, Object> params = new HashMap<>();
        params.put("tranCode", "businessNotification");
        params.put("STATUS", "01");//未读
        params.put("PAGENO", pageIndex);
        params.put("PAGEMAXNUM", pageSize);
        RequestBody body = ApiFactory.get_request(params);
        ApiFactory factory = new ApiFactory();
        Subscription s = factory.get_financing().getBaseApiSingleton().getMessageList(body)
                .map(new Func1<MessageListModel, MessageListModel.ResponseBodyEntity>() {
                    @Override
                    public MessageListModel.ResponseBodyEntity call(MessageListModel model) {
                        count = TypeTranUtils.str2Int(model.getResponseBody().getDatasetSize());
                        return model.getResponseBody();
                    }
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MessageListModel.ResponseBodyEntity>() {
                    @Override
                    public void onCompleted() {
                        hideProgresses();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideProgresses();
                    }

                    @Override
                    public void onNext(MessageListModel.ResponseBodyEntity data) {
                        if (!data.getRESULTCODE().equals("000000")) {
                            T.showShort(data.getRESULTMSG());
                            return;
                        }
                        if (pageIndex == 1) {
                            dataList.clear();
                        }
                        dataList.addAll(data.getData());
                        mAdapter.notifyDataSetChanged();
                        if (dataList.size() >= count) {
                            mAutoLoadListView.setState(LoadingFooter.State.TheEnd);
                        } else {
                            mAutoLoadListView.setState(LoadingFooter.State.Idle);
                        }
                        hideProgresses();

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
}
