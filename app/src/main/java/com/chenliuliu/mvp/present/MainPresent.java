package com.chenliuliu.mvp.present;

import android.os.Handler;

import com.chenliuliu.mvp.activitys.MainActivity;
import com.chenliuliu.mvp.base.MvpPresenter;
import com.chenliuliu.mvp.bean.Testw;
import com.chenliuliu.mvp.net.HttpUtils;
import com.chenliuliu.mvp.net.HttpUtilsCallBack;
import com.chenliuliu.mvp.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * 这种方式适用场景是在Present不复用的情况下 免去各种接口定义繁琐过程
 * 如果有复用时候不适用
 */
public class MainPresent implements MvpPresenter<MainActivity> {
    private MainActivity mView;

    public void getData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("SENSORID", "500004DF6A4A");
                params.put("KEY", "v34uvm9y839vg6y23mhLSKDF84f10a");
                HttpUtils.getInstance().executePost("http://weiguo.hanwei.cn/smart/hwmobile/smart/d002!retrieveRealData", params, new HttpUtilsCallBack<Testw>() {
                    @Override
                    public void onError(String str) {
                        ToastUtils.toast(str, ToastUtils.LENGTH_SHORT);
                    }

                    @Override
                    public void onSuccess(Testw reponse) {
                        mView.showMsg(reponse.getDataObject().get(0).getSensorList().get(0).getLocalHardVersion());
                    }
                }, Testw.class);
            }
        }, 2000);
    }

    /**
     * 设置View实体
     */
    @Override
    public void attachView(MainActivity view) {
        mView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {

    }

    /**
     * 以下3个方法 用于管理present生命周期的  如果业务中不涉及  可以在接口中删除
     */
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
