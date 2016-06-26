package com.toin.work.widget.myDialog;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

import com.toin.work.base.utils.T;


public class _Readme {
    private Activity mActivity;

    public _Readme(Activity activity) {
        mActivity = activity;
    }

    /**
     * 底部弹出选择菜单，模仿ios实现
     */
    public void ActionSheetDialog() {
        new ActionSheetDialog(mActivity).builder().setTitle("请选择操作").setCancelable(false)
                .setCanceledOnTouchOutside(false)
                .addSheetItem("条目一", ActionSheetDialog.SheetItemColor.Red, new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        T.showShort("item" + which);
                    }
                }).addSheetItem("条目二", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onClick(int which) {
            }
        }).addSheetItem("条目三", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onClick(int which) {
            }
        }).show();
    }

    /**
     * 自定义弹窗
     */
    public void MyAlertDialog() {
        final MyAlertDialog dialog = new MyAlertDialog(mActivity).builder().setTitle("title")
                .setView(new View(mActivity)).setEditText("edit").setMsg("msg");
        dialog.setNegativeButton("取消", new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.setPositiveButton("保存", new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
    }
}
