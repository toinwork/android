package com.toin.work;

import android.app.Application;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.toin.work.models.DataModel;
import com.toin.work.models.UserModel;
import com.toin.work.base.utils.STUtils;
import com.toin.work.base.utils.UserCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.umeng.socialize.PlatformConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb on 16/3/28.
 */
public class App extends Application {
    public static Application context;
    public static int         account    = 0;
    public static String      token      = "";
    private static App        instance;
    private List<DataModel>   statusList = new ArrayList<>();

    /* 内存泄露工具 */
    private RefWatcher        refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
        initImageLoader(this);

    }

    public static App getInstance() {
        return instance;
    }

    public List<DataModel> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<DataModel> list) {
        statusList.clear();
        statusList.addAll(list);
    }

    private void init() {
        context = this;
        UserCache.getInstance().setAppContext(context);
        UserModel userModel = UserCache.getInstance().getUser();
        if (!TextUtils.isEmpty(userModel.getToken()) && userModel.getAccount() != -1) {
            token = userModel.getToken();
            account = userModel.getAccount();
        }
        // 工具类初始化
        STUtils.init(this);
        //用于检测内存溢出的
        refWatcher = LeakCanary.install(this);
        initUmeng();
    }

    public static void logout() {
        account = 0;
        token = "";
    }

    private void initUmeng() {
        //微信,新浪,QQ
        PlatformConfig.setWeixin(Config.WXAppID, Config.WXAppSecret);
        PlatformConfig.setSinaWeibo(Config.SINAAppID, Config.SINAAppSecret);
        PlatformConfig.setQQZone(Config.QQAppID, Config.QQAppSecret);
    }

    public static RefWatcher getRefWatcher() {
        return App.getInstance().refWatcher;
    }
    private static void initImageLoader(Application app) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(app.getResources().getDrawable(R.drawable.draw_gray))
                        //                .showImageOnLoading(R.drawable.image_loder_stub)
                .showImageForEmptyUri(R.drawable.image_loder_empty)
                .showImageOnFail(R.drawable.image_loder_error).cacheInMemory(true)
                .cacheOnDisk(true).considerExifParams(true)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT).bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(app)
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .defaultDisplayImageOptions(options).diskCacheSize(50 * 1024 * 1024)
                        // 50 Mb
                .memoryCache(new WeakMemoryCache()).tasksProcessingOrder(QueueProcessingType.LIFO)
                        //                .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }
}
