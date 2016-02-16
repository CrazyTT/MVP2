package com.chenliuliu.mvp.present;

import android.util.Log;

import com.chenliuliu.mvp.activitys.LoginActivity;
import com.chenliuliu.mvp.base.MvpPresenter;
import com.chenliuliu.mvp.bean.Testw;
import com.chenliuliu.mvp.net.HttpUtils;
import com.chenliuliu.mvp.net.HttpUtilsCallBack;
import com.chenliuliu.mvp.utils.DialogUtils;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> params = new HashMap<String, String>();
        params.put("SENSORID", "500004DF6A4A");
        params.put("KEY", "v34uvm9y839vg6y23mhLSKDF84f10a");
        HttpUtils.getInstance().executePost("http://weiguo.hanwei.cn/smart/hwmobile/smart/d002!retrieveRealData", params, new HttpUtilsCallBack<Testw>() {
            @Override
            public void onError(String str) {
                DialogUtils.getInstance().dismiss();
                Log.e("error", str);
            }

            @Override
            public void onSuccess(Testw object) {
                DialogUtils.getInstance().dismiss();
                mView.showMsg(object.getMessage());
            }
        }, Testw.class);
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