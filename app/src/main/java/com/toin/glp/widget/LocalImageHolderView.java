package com.toin.glp.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.toin.glp.tools.singleFactory.MoreManager;

/**
 * Created by hb on 16/9/9.
 */
public class LocalImageHolderView implements Holder<String> {
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, final int position, String data) {
        //        imageView.setImageResource(data);
        MoreManager.getImageLoader().displayImage(data, imageView);
    }
}
