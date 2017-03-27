package com.chenliuliu.mvp.present;

import com.chenliuliu.mvp.activitys.RegisterActity;
import com.chenliuliu.mvp.base.MvpPresenter;
import com.chenliuliu.mvp.base.MvpView;
import com.chenliuliu.mvp.view.RegisterView;

/**
 * Created by liuliuchen on 16/3/4.
 */
public class RegisterPresent implements MvpPresenter<RegisterView> {
    private RegisterView mView;

    @Override
    public void attachView(RegisterView view) {
        this.mView = view;

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

    public void show() {
        mView.setText("你好");
    }
}
