package com.chenliuliu.mvp.present;

import com.chenliuliu.mvp.activitys.MainActivity;
import com.chenliuliu.mvp.base.MvpPresenter;
import com.chenliuliu.mvp.view.MainView;


/**
 * 这种方式适用场景是在Present不复用的情况下 免去各种接口定义繁琐过程
 * 如果有复用时候不适用
 */
public class MainPresent implements MvpPresenter<MainView> {
    private MainView mView;

    public void getData() {
    }

    /**
     * 设置View实体
     */
    @Override
    public void attachView(MainView view) {
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
