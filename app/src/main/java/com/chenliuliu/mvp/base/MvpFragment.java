package com.chenliuliu.mvp.base;

import android.os.Bundle;
import android.view.View;

/**
 * Created by liuliuchen on 16/1/22.
 */
public abstract class MvpFragment<P extends MvpPresenter> extends BaseFragment implements MvpView {
    protected P presenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView(getRetainInstance());
        }
    }

    protected abstract P createPresenter();
}
