package com.toin.glp.ui.mine;

import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseTakePhoneActivity;
import com.toin.glp.tools.singleFactory.MoreManager;
import com.toin.glp.tools.takephoto.app.TakePhoto;
import com.toin.glp.tools.takephoto.compress.CompressConfig;
import com.toin.glp.widget.myDialog.ActionSheetDialog;

import java.io.File;

import butterknife.Bind;

/**
 * 个人资料 Created by hb on 16/6/26.
 */
public class MineInfoActivity extends BaseTakePhoneActivity implements View.OnClickListener,
        TakePhoto.TakeResultListener {
    @Bind(R.id.img_header)
    ImageView headerImg;

    @Override
    protected int initLayout() {
        return R.layout.activity_mine_info;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back, R.id.rl_header);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_INFO);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.rl_header:
                File file = new File(Environment.getExternalStorageDirectory(), "/temp/"
                        + System.currentTimeMillis() + ".jpg");
                if (!file.getParentFile().exists())
                    file.getParentFile().mkdirs();
                Uri imageUri = Uri.fromFile(file);
                new ActionSheetDialog(this)
                        .builder()
                        .setTitle("请选择操作")
                        .setCancelable(false)
                        .setCanceledOnTouchOutside(false)
                        .addSheetItem("相册",
                                ActionSheetDialog.SheetItemColor.Blue,
                                which -> {
                                    //从相册选择照片进行裁剪
                                getTakePhoto().onEnableCompress(
                                        new CompressConfig.Builder().setMaxSize(50 * 1024)
                                                .setMaxPixel(800).create(), true).onPicSelectCrop(
                                        imageUri);
                            })
                        .addSheetItem("拍照",
                                ActionSheetDialog.SheetItemColor.Blue,
                                which -> {
                                    //从相机拍取照片进行裁剪
                                getTakePhoto().onEnableCompress(
                                        new CompressConfig.Builder().setMaxSize(50 * 1024)
                                                .setMaxPixel(800).create(), true).onPicTakeCrop(
                                        imageUri);
                            }).show();
                break;
        }
    }

    @Override
    public void takeSuccess(String imagePath) {
        imagePath = "file:///" + imagePath;
        MoreManager.getImageLoader().displayHead(imagePath, headerImg);
    }

    @Override
    public void takeFail(String msg) {

    }

    @Override
    public void takeCancel() {

    }
}
