package com.chenliuliu.mvp.fragments;

import com.chenliuliu.mvp.base.MvpFragment;
import com.chenliuliu.mvp.base.MvpView;
import com.chenliuliu.mvp.present.FragmentOnePresent;

/**
 * Created by liuliuchen on 16/1/22.
 */
public class FragmentOne extends MvpFragment<FragmentOnePresent> implements MvpView {

    @Override
    protected FragmentOnePresent createPresenter() {
        return new FragmentOnePresent();
    }
}
