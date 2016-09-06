package com.toin.glp.ui;

import com.toin.glp.models.RangeModel;

import java.util.List;

/**
 * Created by hb on 16/4/27.
 */
public interface ViewMiddleView {
    void getGroupsData(List<RangeModel> list);
    void getChildsData(List<RangeModel> list,int position);
}
