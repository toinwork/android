package com.toin.work.http.image;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 图片下载类<br>
 * <ul>
 * <li>String imageUri =“http://site.com/image.png”; // from Web
 * <li>String imageUri =“file:///mnt/sdcard/image.png”; // from SD card
 * <li>String imageUri =“content://media/external/audio/albumart/13″; //
 * fromcontent provider
 * <li>String imageUri =“assets://image.png”; // from assets
 * <li>String imageUri =“drawable://” + R.drawable.image; // from drawables
 * (only images, non-9patch)
 * </ul>
 */
public class STImageLoader {

    private ImageLoader mImageLoader;

    public STImageLoader() {
        mImageLoader = ImageLoader.getInstance();
    }

    public void displayImage(String uri, ImageView imageView) {
        mImageLoader.displayImage(uri, imageView);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
