package com.chenliuliu.mvp.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chenliuliu.mvp.R;
import com.chenliuliu.mvp.base.MvpActivity;
import com.chenliuliu.mvp.base.MvpView;
import com.chenliuliu.mvp.present.RegisterPresent;
import com.chenliuliu.mvp.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.chenliuliu.mvp.view.RegisterView;

public class RegisterActity extends MvpActivity<RegisterPresent> implements RegisterView {

    @Bind(R.id.btn_show)
    public Button mBtnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_actity);
        ButterKnife.bind(this);
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.show();
            }
        });
    }

    @Override
    protected RegisterPresent createPresenter() {
        return new RegisterPresent();
    }

    @Override
    public void setText(String str) {
        ToastUtils.toast(str, ToastUtils.LENGTH_SHORT);
    }
}
