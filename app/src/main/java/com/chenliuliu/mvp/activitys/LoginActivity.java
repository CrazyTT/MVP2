package com.chenliuliu.mvp.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chenliuliu.mvp.R;
import com.chenliuliu.mvp.base.MvpActivity;
import com.chenliuliu.mvp.present.LoginPresent;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends MvpActivity<LoginPresent> {
    private Button btnTest;
    @Bind(R.id.img_test)
    protected ImageView imgTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnTest = (Button) findViewById(R.id.button_test);
        ButterKnife.bind(this);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.show();
            }
        });
    }

    @Override
    protected LoginPresent createPresenter() {
        return new LoginPresent();
    }

    public void showMsg(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        Glide.with(this).load("http://img3.imgtn.bdimg.com/it/u=4245198817,693717552&fm=21&gp=0.jpg").asGif().placeholder(R.mipmap.ic_launcher).override(200, 300).into(imgTest);
    }
}
