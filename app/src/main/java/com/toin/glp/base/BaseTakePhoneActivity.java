package com.toin.glp.base;

import android.content.Intent;
import android.os.Bundle;

import com.nostra13.universalimageloader.utils.L;
import com.toin.glp.tools.takephoto.app.TakePhoto;
import com.toin.glp.tools.takephoto.app.TakePhotoImpl;

/**
 * Created by hb on 16/6/29.
 */
public abstract class BaseTakePhoneActivity extends BaseActivity implements
        TakePhoto.TakeResultListener {
    private TakePhoto takePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 获取TakePhoto实例
     * 
     * @return
     */
    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = new TakePhotoImpl(this, this);
        }
        return takePhoto;
    }

    @Override
    public void takeSuccess(String imagePath) {
        L.i("info", "takeSuccess：" + imagePath);
    }

    @Override
    public void takeFail(String msg) {
        L.w("info", "takeFail:" + msg);
    }

    @Override
    public void takeCancel() {
        L.w("info", "用户取消");
    }
}
