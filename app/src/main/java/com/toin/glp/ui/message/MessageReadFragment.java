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
import com.toin.glp.base.utils.TypeTranUtils;
import com.toin.glp.models.account.MessageListModel;
import com.toin.glp.models.account.MessageModel;
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
 * 已读 Created by hb on 16/6/26.
 */
public class MessageReadFragment extends BaseFragment {
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
        emptyImg.setImageDrawable(getResources().getDrawable(R.mipmap.blank1));
        mAdapter = new CommonAdapter<MessageModel>(getActivity(), dataList, R.layout.item_message) {
            @Override
            public void convert(ViewHolder helper, MessageModel item) {
                TextView redPointTv = helper.getView(R.id.tv_red_point);
                redPointTv.setVisibility(View.GONE);
                TextView contentTv = helper.getView(R.id.tv_content);
                contentTv.setTextColor(getResources().getColor(R.color.gray_content));
                TextView timeTv = helper.getView(R.id.tv_time);
                contentTv.setText(item.getDETAIL());
                int margin = DensityUtil.dip2px(getActivity(), 10);
                contentTv.setText(item.getDETAIL());
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
                            lp.setMargins(0, margin, margin, margin);
                            timeTv.setLayoutParams(lp);
                        } else {
                            flag = true;
                            contentTv.setEllipsize(TextUtils.TruncateAt.END);//收缩
                            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            lp.setMargins(margin, 0, margin, margin);
                            lp.addRule(RelativeLayout.LEFT_OF, R.id.tv_time);
                            contentTv.setLayoutParams(lp);
                            lp = new RelativeLayout.LayoutParams(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                            lp.setMargins(0, 0, margin, 0);
                            timeTv.setLayoutParams(lp);
                        }
                        contentTv.setSingleLine(flag);
                    }
                });
                helper.setText(R.id.tv_time, item.getINPUTDATE());
            }
        };
        mAutoLoadListView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        httpGetMessageList();
    }

    private void httpGetMessageList() {
        Map<String, Object> params = new HashMap<>();
        params.put("tranCode", "businessNotification");
        params.put("STATUS", "02");//已读
        params.put("PAGENO", pageIndex);
        params.put("PAGEMAXNUM", pageSize);
        RequestBody body = ApiFactory.get_request(params);
        ApiFactory factory = new ApiFactory();
        Subscription s = factory.get_financing().getBaseApiSingleton().getMessageList(body)
                .map((Func1<MessageListModel, List<MessageModel>>) model -> {
                    count = TypeTranUtils.str2Int(model.getResponseBody().getDatasetSize());
                    return model.getResponseBody().getData();
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<MessageModel>>() {
                    @Override
                    public void onCompleted() {
                        hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideProgress();
                    }

                    @Override
                    public void onNext(List<MessageModel> data) {
                        hideProgress();
                        if (pageIndex == 1) {
                            dataList.clear();
                        }
                        dataList.addAll(data);
                        mAdapter.notifyDataSetChanged();
                        if (dataList.size() >= count) {
                            mAutoLoadListView.setState(LoadingFooter.State.TheEnd);
                        } else {
                            mAutoLoadListView.setState(LoadingFooter.State.Idle);
                        }
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
        addSubscription(s);
    }

    @Override
    public void initPresenter() {

    }
}
