package com.chenliuliu.mvp.present;

import android.content.Context;
import android.util.Log;

import com.chenliuliu.mvp.activitys.LoginActivity;
import com.chenliuliu.mvp.app.MyApplication;
import com.chenliuliu.mvp.base.MvpPresenter;
import com.chenliuliu.mvp.bean.Weather;
import com.chenliuliu.mvp.net.HttpUtils;
import com.chenliuliu.mvp.net.HttpUtilsCallBack;
import com.chenliuliu.mvp.utils.ToastUtils;
import com.chenliuliu.mvp.view.LoginView;

/**
 * Created by liuliuchen on 16/2/10.
 */
public class LoginPresent implements MvpPresenter<LoginView> {
    private LoginView mView;

    /**
     * 这里可以加入耗时操作
     */
    public void show(Context context) {
        HttpUtils.getInstance().executeGet(context,"http://apicloud.mob.com/v1/weather/query?key=f8090cf6478b&city=无锡", null, new HttpUtilsCallBack<Weather>() {
            @Override
            public void onError(String str) {
                ToastUtils.toast(str, ToastUtils.LENGTH_SHORT);
                Log.e("error", str);
            }

            @Override
            public void onSuccess(Weather object) {
                mView.showMsg(object.getMsg());
            }
        }, Weather.class);
    }

    @Override
    public void attachView(LoginView view) {
        mView = view;
    }


    @Override
    public void detachView(boolean retainInstance) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onCreate() {

    }
}