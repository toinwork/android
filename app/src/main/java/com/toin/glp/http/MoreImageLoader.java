package com.toin.glp.http;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.toin.glp.http.image.STImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class MoreImageLoader {
    private STImageLoader mImageLoader;

    public MoreImageLoader() {
        mImageLoader = new STImageLoader();
    }

    public void displayHead(String uri, ImageView imageView) {
        if (!TextUtils.isEmpty(uri) && uri.contains("oos")) {
            uri = uri + "@80w_80h.jpg";
        }
        mImageLoader.displayImage(uri, imageView);
    }

    public void displayImage(String uri, ImageView imageView) {
        mImageLoader.displayImage(uri, imageView);
    }

    public void displayImage(String uri, ImageView imageView, ImageLoadingListener listener) {
        mImageLoader.getImageLoader().displayImage(uri, imageView, listener);
    }

    public void displayImage(String uri, final ImageView imageView, ImageSize simImageSize) {
        mImageLoader.getImageLoader().loadImage(uri, simImageSize,
                new SimpleImageLoadingListener() {

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        super.onLoadingComplete(imageUri, view, loadedImage);
                        imageView.setImageBitmap(loadedImage);
                    }
                });
    }

    public void displayImage(String uri, SimpleImageLoadingListener listener) {
        mImageLoader.getImageLoader().loadImage(uri, listener);
    }

    public Bitmap loadImageSync(String uri) {
        return mImageLoader.getImageLoader().loadImageSync(uri);
    }

}
