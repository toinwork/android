package com.toin.glp.widget.extendTabView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.toin.glp.R;

public class ViewRight extends RelativeLayout implements ViewBaseAction {

    private ListView         mListView;
    private final String[]   items      = new String[] { "不限", "按发布时间", "租金由低到高", "租金由高到低",
            "面积由小到大", "面积由大到小"         };                                              //显示字段
    private final String[]   itemsVaule = new String[] { "0", "1", "2", "3", "4", "5" }; //隐藏id
    private OnSelectListener mOnSelectListener;
    private TextAdapter      adapter;
    private String           mDistance;
    private String           showText   = "排序";
    private Context          mContext;

    public String getShowText() {
        return showText;
    }

    public ViewRight(Context context) {
        super(context);
        init(context);
    }

    public ViewRight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public ViewRight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_distance, this, true);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.choosearea_bg_right));
        mListView = (ListView) findViewById(R.id.listView);
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
                        showText = "排序";
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
