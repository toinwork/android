package com.toin.glp.ui.home;

import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.ui.mine.CompanyInformationActivity;
import com.toin.glp.widget.LocalImageHolderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 主页 Created by hb on 16/6/25.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private List<String> dataList         = new ArrayList<>();
    @Bind(R.id.convenientBanner)
    ConvenientBanner     convenientBanner = null;

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.img_home1,R.id.img_home2,R.id.img_home3,R.id.img_home4);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TAB_TAG_HOME);
        initBanner();
    }

    @Override
    public void initPresenter() {

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_home1:
                Navigation.goBusinessIntroPage(getActivity(),BusinessIntroductionActivity.PAGE_A);
                break;
            case R.id.img_home2:
                Navigation.goBusinessIntroPage(getActivity(),BusinessIntroductionActivity.PAGE_B);
                break;
            case R.id.img_home3:
                Navigation.goBusinessIntroPage(getActivity(),BusinessIntroductionActivity.PAGE_C);
                break;
            case R.id.img_home4:
                Navigation.goBusinessIntroPage(getActivity(),BusinessIntroductionActivity.PAGE_D);
                break;

        }
    }
}
