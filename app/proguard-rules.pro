-dontwarn
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keepattributes *Annotation*
-keepattributes Signature


-keep class org.eclipse.mat.** { *; }
-keep class com.squareup.leakcanary.** { *; }

-dontwarn org.eclipse.mat.**
-dontwarn com.squareup.leakcanary.**
-dontwarn io.reactivex.**

-keep public class * extends android.view.View {*;}
-keep public class * extends android.widget.BaseAdapter {*;}

-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4.**
-keep public class com.android.vending.licensing.ILicensingService

-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.uuhelper.Application.** { *; }
-keep class net.sourceforge.zbar.** { *; }
-keep class com.google.android.gms.** { *; }

-keep class com.bank.pingan.model.** { *; }

-keepclassmembers class ** {
    public void onEvent*(**);
}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context);
}

-keep class android.support.v7.** { *; }
-keep class com.alibaba.fastjson.** { *; }
-keep class org.apache.http.** { *; }
-keep class com.db.tool.models.** { *; }
-keep class com.google.gson.** { *; }
-keep class com.nostra13.universalimageloader.** { *; }
-keep class cn.bingoogolapple.** { *; }
-keep class com.bigkoo.** { *; }
-keep class org.apache.** {*;}

-dontwarn org.apache.**
-dontwarn com.bigkoo.**
-dontwarn cn.bingoogolapple.**
-dontwarn com.nostra13.universalimageloader.**
-dontwarn com.db.tool.models.**
-dontwarn com.alibaba.fastjson.**
-dontwarn android.support.v7.**
-dontwarn org.apache.http.**
-dontwarn com.google.gson.**

# RxJava相关依赖库
-keep class io.reactivex.** { *; }
# ButterKnife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
# retrofit
-keep class rx.** { *; }
-dontwarn rx.**
-dontwarn retrofit.**
-keep class retrofit.** { *; }
# OkHTTP
-keep class okio.** { *; }
-keep class com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn okio.**
# for RxJava:
-dontwarn sun.misc.Unsafe
# for retrolambda
-dontwarn java.lang.invoke.*

-keep class com.toin.glp.models.** { *; }

-dontwarn
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keepattributes *Annotation*
-keepattributes Signature


-keepattributes Signature
-keep public class * extends android.view.View {*;}
-keep public class * extends android.widget.BaseAdapter {*;}

-keep class com.tencent.** { *; }
-keep class com.ta.utdid2.** { *; }
-keep class com.ut.device.** { *; }
-keep class com.google.gson.** { *; }
-keep class de.greenrobot.event.** { *; }
-keep class com.nostra13.universalimageloader.** { *; }
-keep class com.longevitysoft.android.** { *; }
-keep class net.sf.migbase64.** { *; }
-keep class com.alipay.** { *; }
-keep class com.daimajia.swipe.** { *; }
-keep class cn.jpush.android.** { *; }
-keep class com.sina.sso.** { *; }
-keep class st.utils.** { *; }
-keep class de.greenrobot.event.** { *; }
-keep class io.agora.rtc.** { *; }
-keep class com.alibaba.** { *; }
-keep class com.laiwang.** { *; }
-keep class org.jsoup.** { *; }
-keep class com.joanzapata.pdfview.** { *; }
-keep class org.vudroid.** { *; }
-keep class com.github.ksoichiro.android.observablescrollview.** { *; }
-keep class com.nineoldandroids.** { *; }
-keep class android.support.multidex.** { *; }
-keep class com.android.test.runner.** { *; }
-keep class com.astuetz.** { *; }


#2.0.9后的不需要加下面这个keep
#-keep class org.xbill.DNS.** {*;}
#另外，demo中发送表情的时候使用到反射，需要keep SmileUtils
-keep class com.easemob.chatuidemo.utils.SmileUtils {*;}
#注意前面的包名，如果把这个类复制到自己的项目底下，比如放在com.example.utils底下，应该这么写(实际要去掉#)
#-keep class com.example.utils.SmileUtils {*;}
#如果使用easeui库，需要这么写
-keep class com.easemob.easeui.utils.EaseSmileUtils {*;}
#2.0.9后加入语音通话功能，如需使用此功能的api，加入以下keep
-dontwarn ch.imvs.**
-dontwarn org.slf4j.**
-keep class org.ice4j.** {*;}
-keep class net.java.sip.** {*;}
-keep class org.webrtc.voiceengine.** {*;}
-keep class org.bitlet.** {*;}
-keep class org.slf4j.** {*;}
-keep class ch.imvs.** {*;}

-dontwarn com.umeng.**
-dontwarn com.ta.utdid2.**
-dontwarn com.ut.device.**
-dontwarn com.google.gson.**
-dontwarn de.greenrobot.event.**
-dontwarn com.nostra13.universalimageloader.**
-dontwarn com.longevitysoft.android.**
-dontwarn net.sf.migbase64.**
-dontwarn com.alipay.**
-dontwarn com.daimajia.swipe.**
-dontwarn cn.jpush.android.**
-dontwarn com.sina.sso.**
-dontwarn com.baidu.**
-dontwarn st.utils.**
-dontwarn de.greenrobot.event.**
-dontwarn io.agora.rtc.**
-dontwarn com.alibaba.**
-dontwarn com.laiwang.**
-dontwarn org.jsoup.**
-dontwarn sun.misc.Unsafe
-dontwarn android.util.FloatMath
-dontwarn st.widget.multiColumnListView.PLA_AbsListView
-dontwarn com.taobao.**
-dontwarn com.joanzapata.pdfview.**
-dontwarn org.vudroid.**
-dontwarn com.github.ksoichiro.android.observablescrollview.**
-dontwarn com.nineoldandroids.**
-dontwarn android.support.multidex.**
-dontwarn com.android.test.runner.**
-dontwarn com.astuetz.**

-keep class com.baidu.** { *; }

-keep class vi.com.gdi.bgl.android.**{*;}

-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class com.android.vending.licensing.ILicensingService

-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.uuhelper.Application.** { *; }
-keep class net.sourceforge.zbar.** { *; }
-keep class com.google.android.gms.** { *; }

-keep class com.bank.pingan.model.UserModel.** { *; }

-keep public class * extends com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
-keep public class * extends com.j256.ormlite.android.apptools.OpenHelperManager

-keep class com.android.vending.licensing.ILicensingService
-keep class android.support.v4.** { *; }
-keep class android.support.v7.** { *; }
-keep class org.apache.commons.net.** { *; }

-keep class com.umeng.** { *; }
-keep class com.j256.ormlite.** { *; }

-dontwarn com.j256.ormlite.**
-dontwarn android.support.v4.**
-dontwarn android.support.v7.**
-dontwarn org.apache.commons.net.**
-dontwarn com.tencent.**

-keepclassmembers class ** {
    public void onEvent*(**);
}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context);
}

-keep enum com.facebook.**
-keepattributes Exceptions,InnerClasses,Signature
-keepattributes SourceFile,LineNumberTable

-keep public interface com.facebook.**
-keep public interface com.tencent.**
-keep public interface com.umeng.socialize.**
-keep public interface com.umeng.scrshot.**

-keep public class javax.** { *; }
-keep public class android.webkit.** { *; }


-dontshrink
-dontoptimize
-dontwarn com.google.android.maps.**
-dontwarn android.webkit.**
-dontwarn com.umeng.**
-dontwarn com.tencent.weibo.sdk.**
-dontwarn com.facebook.**


-keep public class [your_pkg].R$*{
    public static final int *;
}

# LeakCanary 内存泄露检测
-keep class org.eclipse.mat.** { *; }
-keep class com.squareup.leakcanary.** { *; }

-dontwarn org.eclipse.mat.**
-dontwarn com.squareup.leakcanary.**
-dontwarn io.reactivex.**


# RxJava相关依赖库
-keep class io.reactivex.** { *; }
# ButterKnife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
# retrofit
-keep class rx.** { *; }
-dontwarn rx.**
-dontwarn retrofit.**
-keep class retrofit.** { *; }
# OkHTTP
-keep class okio.** { *; }
-keep class com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn okio.**
# for RxJava:
-dontwarn sun.misc.Unsafe
# for retrolambda
-dontwarn java.lang.invoke.*

