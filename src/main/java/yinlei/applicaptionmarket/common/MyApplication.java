package yinlei.applicaptionmarket.common;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 在这里初始化一些需要用到的第三方框架
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: MyApplication.java
 * @author: 若兰明月
 * @date: 2016-06-09 14:35
 */

public class MyApplication extends Application {

    private static MyApplication application;
    private Graph mGraph;


    public static MyApplication getApplication() {

        if (application == null) {
            application = new MyApplication();
        }

        return application;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        Fresco.initialize(this);
        mGraph = Graph.Initializer.init();
    }


    public Graph getGraph() {
        return mGraph;
    }

    /**
     * 获取当前版本信息
     *
     * @return
     */
    public String getVersion() {
        PackageManager manager = this.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return "V " + version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "未知";
        }

    }


}
