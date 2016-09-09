package com.toin.glp.ui.home;

import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
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
public class HomeFragment extends BaseFragment {

    private List<String> dataList         = new ArrayList<>();
    private List<View>   views;
    @Bind(R.id.convenientBanner)
    ConvenientBanner     convenientBanner = null;

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
        dataList.add("http://zmall.oss-cn-hangzhou.aliyuncs.com/public/2016/09/08/57d10fd79b8b3.jpg");
        dataList.add("http://zmall.oss-cn-hangzhou.aliyuncs.com/public/2016/09/08/57d10c68c9e62.jpg");
        dataList.add("http://zmall.oss-cn-hangzhou.aliyuncs.com/public/2016/09/08/57d10c249f060.jpg");
        dataList.add("http://zmall.oss-cn-hangzhou.aliyuncs.com/public/2016/09/08/57d10cd502376.jpg");
        convenientBanner.setPages(() -> new LocalImageHolderView(), dataList)
                .setPageIndicator(new int[] { R.mipmap.point_focused, R.mipmap.point_unfocused })
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
    }

}
