package com.toin.glp.base.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.utils.ShareBoardlistener;

import java.util.Map;

public class ShareUtils {

    private Context            mContext;
    private UMShareAPI         mShareAPI;
    private int                shareImageRes;
    private String             title;
    private String             targetUrl;
    private String             content;
    private UMShareListener    umShareListener;
    private SHARE_MEDIA        shareMedia;
    private ShareBoardlistener shareBoardlistener;

    public ShareUtils(Activity activity, int shareImageRes, String title, String content,
                      String targetUrl, UMShareListener umShareListener,
                      ShareBoardlistener shareBoardlistener) {
        mContext = activity;
        mShareAPI = UMShareAPI.get(mContext);
        this.shareImageRes = shareImageRes;
        this.title = title;
        this.targetUrl = targetUrl;
        this.content = content;
        this.umShareListener = umShareListener;
        this.shareBoardlistener = shareBoardlistener;
    }

    /**
     * 各个平台分享
     * 
     * @param shareMedia
     */
    public void sharePlat(SHARE_MEDIA shareMedia) {
        this.shareMedia = shareMedia;
        if (shareMedia.equals(SHARE_MEDIA.SINA) || shareMedia.equals(SHARE_MEDIA.QQ)) {
            mShareAPI.doOauthVerify((Activity) mContext, shareMedia, umAuthListener);
        } else {
            shareTo();
        }
    }

    private void shareTo() {
        UMImage image = new UMImage(mContext, BitmapFactory.decodeResource(mContext.getResources(),
                shareImageRes));
        new ShareAction((Activity) mContext).setPlatform(shareMedia).withText(content)
                .withTitle(title).withTargetUrl(targetUrl).withMedia(image)
                .setListenerList(umShareListener).setShareboardclickCallback(shareBoardlistener)
                .share();
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
                                              @Override
                                              public void onComplete(SHARE_MEDIA platform,
                                                                     int action,
                                                                     Map<String, String> data) {
                                                  shareTo();
                                              }

                                              @Override
                                              public void onError(SHARE_MEDIA platform, int action,
                                                                  Throwable t) {
                                                  Toast.makeText(mContext, "Authorize fail",
                                                          Toast.LENGTH_SHORT).show();
                                              }

                                              @Override
                                              public void onCancel(SHARE_MEDIA platform, int action) {
                                                  Toast.makeText(mContext, "Authorize cancel",
                                                          Toast.LENGTH_SHORT).show();
                                              }
                                          };
}
