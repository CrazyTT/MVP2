package com.chenliuliu.mvp.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chenliuliu.mvp.R;
import com.chenliuliu.mvp.base.MvpActivity;
import com.chenliuliu.mvp.present.MainPresent;


public class MainActivity extends MvpActivity<MainPresent> {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn_test);
        mTextView = (TextView) this.findViewById(R.id.txt_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData();
            }
        });
    }

    @Override
    protected MainPresent createPresenter() {
        return new MainPresent();
    }

    public void showMsg(String str) {
        mTextView.setText(str);
    }
}
