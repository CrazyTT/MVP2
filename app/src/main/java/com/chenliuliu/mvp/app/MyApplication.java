package com.chenliuliu.mvp.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by liuliuchen on 16/2/18.
 */
public class MyApplication extends Application {
    public MyApplication() {
        instance = this;
    }

    private static volatile MyApplication instance = null;

    @Override
    public void onCreate() {
        //https信任证书
//        HttpUtils.getInstance().getHttpUtils().setCertificates(new InputStream[]{
//                new Buffer()
//                        .writeUtf8("")
//                        .inputStream()});
        super.onCreate();
    }

    public static Context getInstance() {
        if (null == instance) {
            synchronized (MyApplication.class) {
                if (null == instance) {
                    instance = new MyApplication();
                }
            }
        }
        return instance;
    }
}
