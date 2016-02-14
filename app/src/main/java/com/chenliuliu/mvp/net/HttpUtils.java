package com.chenliuliu.mvp.net;

import com.chenliuliu.mvp.BuildConfig;
import com.socks.library.KLog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by liuliuchen on 16/1/21.
 */
public class HttpUtils<T> {

    private volatile static OkHttpUtils okHttpUtils;

    private volatile static HttpUtils instance;

    private HttpUtils() {
    }

    public static HttpUtils getInstance() {
        if (null == instance) {
            synchronized (HttpUtils.class) {
                if (null == instance) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    /**
     * @param url      地址
     * @param params   form表单
     * @param callback 自定义回掉
     * @param mClass   回掉类型
     */
    public void executeGet(final String url, Map<String, String> params, final HttpUtilsCallBack<T> callback, final Class<T> mClass) {
        getHttpUtils().get().url(url).params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                if (BuildConfig.DEBUG) {
                    KLog.e(e.getMessage());
                }
                callback.onError("网络错误");
            }

            @Override
            public void onResponse(String response) {
                if (BuildConfig.DEBUG) {
                    KLog.json("response", response);
                }
                T responseObject =  (T)JsonUtils.getInstance().json2object(response, mClass);
                if (responseObject != null) {
                    callback.onSuccess(responseObject);
                } else {
                    callback.onError("网络错误");
                }
            }
        });
    }


    /**
     * @param url      地址
     * @param params   form表单
     * @param callback okhttp自带的回掉
     */
    public void executeGet(final String url, Map<String, String> params, Callback callback) {
        getHttpUtils().get().url(url).params(params).build().execute(callback);
    }

    /**
     * @param url      地址
     * @param params   form表单
     * @param callback okhttp自带的回掉
     */
    public void executePost(final String url, Map<String, String> params, Callback callback) {
        getHttpUtils().post().url(url).params(params).build().execute(callback);
    }

    /**
     * @param url      地址
     * @param params   form表单
     * @param callback 自定义回掉
     * @param mClass   回掉类型
     */
    public void executePost(final String url, Map<String, String> params, final HttpUtilsCallBack<T> callback, final Class<T> mClass) {
        getHttpUtils().post().url(url).params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                if (BuildConfig.DEBUG) {
                    KLog.e(e.getMessage());
                }
                callback.onError("网络错误");
            }

            @Override
            public void onResponse(String response) {
                if (BuildConfig.DEBUG) {
                    KLog.json("response", response);
                }
                T responseObject = (T) JsonUtils.getInstance().json2object(response, mClass);
                if (responseObject != null) {
                    callback.onSuccess(responseObject);
                } else {
                    callback.onError("网络错误");
                }
            }
        });
    }


    /**
     * @param url 根据访问地址，cancle request
     */
    public void cancleWithUrl(String url) {
        RequestCall call = getHttpUtils().get().url(url).build();
        call.cancel();
    }

    /**
     * @param tag 根据TAG，cancle request
     */
    public void cancleWithTag(String tag) {
        getHttpUtils().cancelTag(tag);
    }

    private OkHttpUtils getHttpUtils() {
        if (null == okHttpUtils) {
            synchronized (HttpUtils.class) {
                if (null == okHttpUtils) {
                    okHttpUtils = OkHttpUtils.getInstance();
                }
            }
        }
        return okHttpUtils;
    }
}