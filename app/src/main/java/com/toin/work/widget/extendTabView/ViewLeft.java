package com.toin.work.widget.extendTabView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.toin.work.App;
import com.toin.work.R;
import com.toin.work.models.DataModel;
import com.toin.work.base.utils.WindowManagerUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 状态
 */

public class ViewLeft extends RelativeLayout implements ViewBaseAction {

    private ListView         mListView;
    private List<DataModel>  dataList = new ArrayList<>();
    private String[]         items;                       //显示字段
    private String[]         itemsVaule;                  //隐藏id
    private OnSelectListener mOnSelectListener;
    private TextAdapter      adapter;
    private String           mDistance;
    private String           showText = "状态";
    private Context          mContext;

    public String getShowText() {
        return showText;
    }

    public ViewLeft(Context context) {
        super(context);
        initData();
        init(context);
    }

    public ViewLeft(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public ViewLeft(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void initData() {
        dataList.clear();
        dataList.addAll(App.getInstance().getStatusList());
        items = new String[dataList.size() + 1];
        itemsVaule = new String[dataList.size() + 1];
        items[0] = "不限";
        itemsVaule[0] = "";
        for (int i = 0; i < dataList.size(); i++) {
            items[i + 1] = dataList.get(i).getName();
            itemsVaule[i + 1] = String.valueOf(dataList.get(i).getTag_id());
        }
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_distance, this, true);
        //setBackgroundDrawable(getResources().getDrawable(R.drawable.choosearea_bg_mid));
        mListView = (ListView) findViewById(R.id.listView);
        //设置margin
        int width = WindowManagerUtils.getWindowWidth(context) / 3;
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mListView.getLayoutParams();
        lp.setMargins(width, 0, 0, 0);
        lp.width = width;
        mListView.setLayoutParams(lp);
        //设置width
//        ViewGroup.LayoutParams lps = mListView.getLayoutParams();
//        lps.width = width;
//        mListView.setLayoutParams(lps);

        adapter = new TextAdapter(context, items, R.drawable.choose_item_right,
                R.drawable.choose_eara_item_selector);
        adapter.setTextSize(14);
        if (mDistance != null) {
            for (int i = 0; i < itemsVaule.length; i++) {
                if (itemsVaule[i].equals(mDistance)) {
                    adapter.setSelectedPositionNoNotify(i);
                    showText = items[i];
                    break;
                }
            }
        }
        mListView.setAdapter(adapter);
        adapter.setOnItemClickListener(new TextAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                if (mOnSelectListener != null) {
                    showText = items[position];
                    if (items[position].equals("不限")) {
                        showText = "状态";
                    }
                    mOnSelectListener.getValue(itemsVaule[position], showText);
                }
            }
        });
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        mOnSelectListener = onSelectListener;
    }

    public interface OnSelectListener {
        public void getValue(String distance, String showText);
    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

}
