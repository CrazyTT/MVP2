package com.chenliuliu.mvp.present;

import android.util.Log;
import com.chenliuliu.mvp.activitys.LoginActivity;
import com.chenliuliu.mvp.base.MvpPresenter;
import com.chenliuliu.mvp.bean.Weather;
import com.chenliuliu.mvp.net.HttpUtils;
import com.chenliuliu.mvp.net.HttpUtilsCallBack;
import com.chenliuliu.mvp.utils.DialogUtils;
import com.chenliuliu.mvp.utils.ToastUtils;

/**
 * Created by liuliuchen on 16/2/10.
 */
public class LoginPresent implements MvpPresenter<LoginActivity> {
    private LoginActivity mView;

    /**
     * 这里可以加入耗时操作
     */
    public void show() {
        DialogUtils.getInstance().show(mView);
        HttpUtils.getInstance().executeGet("http://apicloud.mob.com/v1/weather/query?key=f8090cf6478b&city=无锡", null, new HttpUtilsCallBack<Weather>() {
            @Override
            public void onError(String str) {
                ToastUtils.toast(str, ToastUtils.LENGTH_SHORT);
                DialogUtils.getInstance().dismiss();
                Log.e("error", str);
            }

            @Override
            public void onSuccess(Weather object) {
                DialogUtils.getInstance().dismiss();
                mView.showMsg(object.getMsg());
            }
        }, Weather.class);
    }

    @Override
    public void attachView(LoginActivity view) {
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