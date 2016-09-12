package com.toin.glp.ui.home;

import android.view.View;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.models.UserModel;
import com.toin.glp.ui.mine.CompanyInformationActivity;
import com.toin.glp.widget.LocalImageHolderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 主页 Created by hb on 16/6/25.
 */
public class HomeFragment extends BaseFragment {

    private List<String> dataList         = new ArrayList<>();
    private List<View>   views;
    @Bind(R.id.convenientBanner)
    ConvenientBanner     convenientBanner = null;
    @Bind(R.id.tv_content)
    TextView             contentTv;

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TAB_TAG_HOME);
        initBanner();
        testApi();
    }

    private void testApi() {
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", "login_member");
        params.put("partner_id", "188888888");
        params.put("mobile", "18968142405");
        params.put("login_pwd", "123456");
        ApiFactory factory = new ApiFactory();
        Subscription s = factory.get_weijin().getBaseApiSingleton().login(params)
                .map(userModel -> userModel).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<UserModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        contentTv.setText(userModel.getMobile_star());
                    }
                });
        addSubscription(s);
    }

    private void initBanner() {
        dataList.add("http://zmall.oss-cn-hangzhou.aliyuncs.com/public/2016/09/08/57d10fd79b8b3.jpg");
        dataList.add("http://zmall.oss-cn-hangzhou.aliyuncs.com/public/2016/09/08/57d10c68c9e62.jpg");
        dataList.add("http://zmall.oss-cn-hangzhou.aliyuncs.com/public/2016/09/08/57d0e1bae7983.jpg");
        dataList.add("http://zmall.oss-cn-hangzhou.aliyuncs.com/public/2016/09/08/57d0e1a333fef.jpg");
        convenientBanner.setPages(() -> new LocalImageHolderView(), dataList)
                .setPageIndicator(new int[] { R.mipmap.point_focused, R.mipmap.point_unfocused })
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);

        convenientBanner.setOnItemClickListener(position -> {
            Navigation.goPage(getActivity(), CompanyInformationActivity.class);
        });
    }

}
