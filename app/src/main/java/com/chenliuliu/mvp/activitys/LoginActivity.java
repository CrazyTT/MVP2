package com.chenliuliu.mvp.activitys;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.chenliuliu.mvp.R;
import com.chenliuliu.mvp.base.MvpActivity;
import com.chenliuliu.mvp.present.LoginPresent;
import com.chenliuliu.mvp.utils.ToastUtils;
import com.chenliuliu.mvp.utils.ViewAnimation.ViewAnimator;
import com.chenliuliu.mvp.view.LoginView;

public class LoginActivity extends MvpActivity<LoginPresent> implements LoginView {
    @Bind(R.id.img_test2)
    ImageView mImgTest2;
    @Bind(R.id.img_test)
    protected ImageView imgTest;
    @Bind(R.id.button_test)
    Button buttonTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.show(context);
            }
        });
        ViewAnimator.animate(mImgTest2).dp().repeatCount(ValueAnimator.INFINITE).rotation(0, 360).duration(2000).translationX(0, 60).translationY(0, 90).alpha(0, 1).start();
    }

    @Override
    protected LoginPresent createPresenter() {
        return new LoginPresent();
    }

    public void showMsg(String str) {
        ToastUtils.toast(str, ToastUtils.LENGTH_SHORT);
        Glide.with(this).load("http://img3.imgtn.bdimg.com/it/u=4245198817,693717552&fm=21&gp=0.jpg").asGif().placeholder(R.mipmap.ic_launcher).override(200, 300).into(imgTest);
    }
}
