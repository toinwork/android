package com.toin.glp;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.toin.glp.base.utils.STUtils;
import com.toin.glp.base.utils.SharedPreferencesUtil;
import com.toin.glp.base.utils.UserCache;
import com.toin.glp.utils.CrashHandler;

/**
 * Created by hb on 16/3/28.
 */
public class App extends Application {
    public static Application context;
    public static String      token = "";
    public static String      phone = "";
    private static App        instance;

    /* 内存泄露工具 */
    private RefWatcher        refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
        instance = this;
        init();
        initImageLoader(this);

    }

    public static App getInstance() {
        return instance;
    }

    private void init() {
        context = this;
        UserCache.getInstance().setAppContext(context);
        token = UserCache.getToken(this);
        phone = SharedPreferencesUtil.getStringValue(this, "phone");
        // 工具类初始化
        STUtils.init(this);
        //用于检测内存溢出的
        refWatcher = LeakCanary.install(this);
    }

    public static void logout() {
        token = "";
    }

    public static RefWatcher getRefWatcher() {
        return App.getInstance().refWatcher;
    }

    private static void initImageLoader(Application app) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(app.getResources().getDrawable(R.drawable.draw_gray))
                .showImageForEmptyUri(R.drawable.image_loder_empty)
                .showImageOnFail(R.drawable.image_loder_error).cacheInMemory(true)
                .cacheOnDisk(true).considerExifParams(true)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT).bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(app)
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .defaultDisplayImageOptions(options).diskCacheSize(50 * 1024 * 1024)
                .memoryCache(new WeakMemoryCache()).tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();
        ImageLoader.getInstance().init(config);
    }
}
