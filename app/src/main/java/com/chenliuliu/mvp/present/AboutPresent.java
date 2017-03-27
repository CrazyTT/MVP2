package com.chenliuliu.mvp.present;

import com.chenliuliu.mvp.activitys.AboutActivity;
import com.chenliuliu.mvp.base.MvpPresenter;
import com.chenliuliu.mvp.view.AboutView;

/**
 * Created by liuliuchen on 16/3/4.
 */
public class AboutPresent implements MvpPresenter<AboutView> {
    private AboutView mView;

    @Override
    public void attachView(AboutView view) {
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
}
