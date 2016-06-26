package com.toin.work.widget.extendTabView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.toin.work.R;
import com.toin.work.models.RangeModel;
import com.toin.work.ui.ViewMiddleView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ViewMiddle extends LinearLayout implements ViewBaseAction, ViewMiddleView {

    private ListView                            regionListView;
    private ListView                            plateListView;
    private ArrayList<String>                   groups           = new ArrayList<String>();
    private LinkedList<String>                  childrenItem     = new LinkedList<String>();
    private SparseArray<LinkedList<String>>     children         = new SparseArray<LinkedList<String>>();
    private LinkedList<RangeModel>              childrenDataItem = new LinkedList<RangeModel>();
    private SparseArray<LinkedList<RangeModel>> childrenData     = new SparseArray<LinkedList<RangeModel>>();
    private List<RangeModel>                    groupsList       = new ArrayList<>();
    private List<Integer>                       keyList          = new ArrayList<>();                        //记录每次添加的地区数据key,防止每次加载
    private TextAdapter                         plateListViewAdapter;
    private TextAdapter                         earaListViewAdapter;
    private OnSelectListener                    mOnSelectListener;
    private int                                 tEaraPosition    = 0;
    private int                                 tBlockPosition   = 0;
    private String                              showString       = "区域";
//    private ViewMiddlePresenterImpl             presenter        = null;
    private Context                             mContext;

    public ViewMiddle(Context context) {
        super(context);
        init(context);
    }

    public ViewMiddle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_region, this, true);
        regionListView = (ListView) findViewById(R.id.listView);
        plateListView = (ListView) findViewById(R.id.listView2);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.choosearea_bg_left));

        initData();

        earaListViewAdapter = new TextAdapter(context, groups, R.mipmap.choose_item_selected,
                R.drawable.choose_eara_item_selector);
        earaListViewAdapter.setTextSize(14);
        earaListViewAdapter.setSelectedPositionNoNotify(tEaraPosition);
        regionListView.setAdapter(earaListViewAdapter);
        earaListViewAdapter.setOnItemClickListener(new TextAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                if (position == 0) {
                    if (mOnSelectListener != null) {
                        mOnSelectListener.getValue(0, "区域");
                    }
                } else if (position <= groupsList.size() && position > 0) {
                    int pos = position - 1;
                    RangeModel model = groupsList.get(pos);
                    if (keyList.contains(pos)) {
                        putChildData(pos);
                    } else {
                        keyList.add(pos);
//                        presenter.getChildsInfo(model.getId(), pos);
                    }
                }
            }
        });
        if (tEaraPosition < children.size()) {
            childrenItem.addAll(children.get(tEaraPosition));
            childrenDataItem.addAll(childrenData.get(tEaraPosition));
        }
        plateListViewAdapter = new TextAdapter(context, childrenItem, R.drawable.choose_item_right,
                R.drawable.choose_plate_item_selector);
        plateListViewAdapter.setTextSize(15);
        plateListViewAdapter.setSelectedPositionNoNotify(tBlockPosition);
        plateListView.setAdapter(plateListViewAdapter);
        plateListViewAdapter.setOnItemClickListener(new TextAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, final int position) {
                showString = childrenItem.get(position);
                RangeModel model = childrenDataItem.get(position);
                if (mOnSelectListener != null) {
                    mOnSelectListener.getValue(model.getId(), showString);
                }

            }
        });
        if (tBlockPosition < childrenItem.size())
            showString = childrenItem.get(tBlockPosition);
        if (showString.contains("区域")) {
            //showString = showString.replace("不限", "");
        }
        setDefaultSelect();
    }

    private void initData() {
//        presenter = new ViewMiddlePresenterImpl(this, mContext);
//        presenter.getGroupsInfo();
    }

    @Override
    public void getGroupsData(List<RangeModel> list) {
        groups.add("不限");
        groupsList.clear();
        groupsList.addAll(list);
        LinkedList<String> dataList = new LinkedList<String>();
        children.put(0, dataList);
        for (int i = 0; i < list.size(); i++) {
            groups.add(list.get(i).getName());
        }
    }

    @Override
    public void getChildsData(List<RangeModel> list, int position) {
        LinkedList<String> dataList = new LinkedList<String>();
        LinkedList<RangeModel> rangeModels = new LinkedList<RangeModel>();
        rangeModels.clear();
        rangeModels.addAll(list);
        for (int i = 0; i < list.size(); i++) {
            dataList.add(list.get(i).getName());
        }
        children.put(position, dataList);
        childrenData.put(position, rangeModels);

        putChildData(position);

    }

    private void putChildData(int position) {
        childrenItem.clear();
        childrenDataItem.clear();
        childrenItem.addAll(children.get(position));
        childrenDataItem.addAll(childrenData.get(position));
        plateListViewAdapter.notifyDataSetChanged();
    }

    public void setDefaultSelect() {
        regionListView.setSelection(tEaraPosition);
        plateListView.setSelection(tBlockPosition);
    }

    public String getShowText() {
        return showString;
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        mOnSelectListener = onSelectListener;
    }

    public interface OnSelectListener {
        public void getValue(int id, String showText);
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }
}
