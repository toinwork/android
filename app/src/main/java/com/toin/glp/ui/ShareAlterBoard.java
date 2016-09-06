package com.toin.glp.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.toin.glp.R;

public class ShareAlterBoard extends PopupWindow implements OnClickListener, AlterListener {
    private static final int QQ            = 1;
    private static final int WEIXIN_CIRCLR = 2;
    private static final int WEIXIN        = 3;
    private static final int SINA          = 4;
    private static final int SMS           = 5;
    private static final int COPY          = 6;
    private static final int CANCLE        = 7;
    private Activity         activity;
    private AlterListener    alterListener;
    private View             rootView      = null;
    private int              layout;
    private TextView         qqTv;
    private TextView         weiXinCircleTv;
    private TextView         weiXinTv;
    private TextView         sinaTv;
    private TextView         smsTv;
    private TextView         copyUrlTv;
    private TextView         cancleTv;

    public ShareAlterBoard(Activity activity, int layout, AlterListener alterListener) {
        super(activity);
        this.activity = activity;
        this.alterListener = alterListener;
        this.layout = layout;
        initView(activity);
    }

    @SuppressWarnings("deprecation")
    private void initView(Context context) {
        rootView = LayoutInflater.from(context).inflate(R.layout.layout_share, null);
        RelativeLayout backRl = (RelativeLayout) rootView.findViewById(R.id.rl_back);
        initShareImg();
        backRl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        setContentView(rootView);
        setWidth(LayoutParams.MATCH_PARENT);
        setHeight(LayoutParams.FILL_PARENT);
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setTouchable(true);
        this.setAnimationStyle(R.style.popwin_anim_style);
    }

    private void initShareImg() {
        qqTv = (TextView) rootView.findViewById(R.id.tv_qq);
        weiXinCircleTv = (TextView) rootView.findViewById(R.id.tv_weixin_circle);
        weiXinTv = (TextView) rootView.findViewById(R.id.tv_weixin);
        sinaTv = (TextView) rootView.findViewById(R.id.tv_sina);
        smsTv = (TextView) rootView.findViewById(R.id.tv_sms);
        copyUrlTv = (TextView) rootView.findViewById(R.id.tv_copy);
        cancleTv = (TextView) rootView.findViewById(R.id.tv_cancle);
        qqTv.setTag(QQ);
        weiXinCircleTv.setTag(WEIXIN_CIRCLR);
        weiXinTv.setTag(WEIXIN);
        sinaTv.setTag(SINA);
        smsTv.setTag(SMS);
        copyUrlTv.setTag(COPY);
        cancleTv.setTag(CANCLE);
        qqTv.setOnClickListener(this);
        weiXinCircleTv.setOnClickListener(this);
        weiXinTv.setOnClickListener(this);
        sinaTv.setOnClickListener(this);
        smsTv.setOnClickListener(this);
        copyUrlTv.setOnClickListener(this);
    }

    public void show() {
        this.showAtLocation(LayoutInflater.from(activity).inflate(layout, null), Gravity.BOTTOM, 0,
                0);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public void onClick(View view) {
        if (!view.getTag().equals("") || view.getTag() != null) {
            if (view.getTag().equals(QQ)) {
                alterListener.onPosition(QQ);
                dismiss();
            } else if (view.getTag().equals(WEIXIN_CIRCLR)) {
                alterListener.onPosition(WEIXIN_CIRCLR);
                dismiss();
            } else if (view.getTag().equals(WEIXIN)) {
                alterListener.onPosition(WEIXIN);
                dismiss();
            } else if (view.getTag().equals(SINA)) {
                alterListener.onPosition(SINA);
                dismiss();
            } else if (view.getTag().equals(SMS)) {
                alterListener.onPosition(SMS);
                dismiss();
            } else if (view.getTag().equals(COPY)) {
                alterListener.onPosition(COPY);
                dismiss();
            } else if (view.getTag().equals(CANCLE)) {
                alterListener.onPosition(CANCLE);
                dismiss();
            }
        } else {
            return;
        }
    }

    @Override
    public void onPosition(int position) {

    }

}
