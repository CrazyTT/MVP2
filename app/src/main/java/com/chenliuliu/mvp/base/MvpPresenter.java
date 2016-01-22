package com.chenliuliu.mvp.base;

/**
 */
public interface MvpPresenter<V extends MvpView> {
    void attachView(V view);
    void detachView(boolean retainInstance);
    void onStart();
    void onStop();
    void onCreate();
}
