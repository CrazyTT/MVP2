package com.chenliuliu.mvp.activitys;

import android.os.Bundle;

import com.chenliuliu.mvp.R;
import com.chenliuliu.mvp.base.MvpActivity;
import com.chenliuliu.mvp.base.MvpView;
import com.chenliuliu.mvp.present.AboutPresent;
import com.chenliuliu.mvp.view.AboutView;

public class AboutActivity extends MvpActivity<AboutPresent> implements AboutView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    protected AboutPresent createPresenter() {
        return new AboutPresent();
    }
}
