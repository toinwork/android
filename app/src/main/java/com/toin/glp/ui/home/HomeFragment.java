package com.toin.glp.ui.home;

import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.widget.LocalImageHolderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 主页 Created by hb on 16/6/25.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private List<Integer>      dataList         = new ArrayList<>();
    @Bind(R.id.convenientBanner)
    ConvenientBanner           convenientBanner = null;

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.img_home1, R.id.img_home2, R.id.img_home3);
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
        dataList.add(R.mipmap.banner1);
        dataList.add(R.mipmap.banner2);
        dataList.add(R.mipmap.banner3);
        convenientBanner.setPages(() -> new LocalImageHolderView(), dataList)
                .setPageIndicator(new int[] { R.mipmap.point_focused, R.mipmap.point_unfocused })
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(3000);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_home1:
                Navigation.goBusinessIntroPage(getActivity(), BusinessIntroductionActivity.PAGE_A);
                break;
            case R.id.img_home2:
                Navigation.goBusinessIntroPage(getActivity(), BusinessIntroductionActivity.PAGE_C);
                break;
            case R.id.img_home3:
                Navigation.goBusinessIntroPage(getActivity(), BusinessIntroductionActivity.PAGE_B);
                break;

        }
    }
}
