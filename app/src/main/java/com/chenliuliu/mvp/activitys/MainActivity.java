package com.chenliuliu.mvp.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chenliuliu.mvp.R;
import com.chenliuliu.mvp.base.MvpActivity;
import com.chenliuliu.mvp.present.MainPresent;
import com.chenliuliu.mvp.utils.ViewAnimation.ViewAnimator;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.chenliuliu.mvp.view.MainView;


public class MainActivity extends MvpActivity<MainPresent> implements MainView{
    boolean isOpen = false;
    @Bind(R.id.btn_meun)
    Button mBtnMeun;
    @Bind(R.id.btn_one)
    Button mBtnOne;
    @Bind(R.id.btn_two)
    Button mBtnTwo;
    @Bind(R.id.btn_three)
    Button mBtnThree;
    @Bind(R.id.btn_four)
    Button mBtnFour;
    @Bind(R.id.btn_five)
    Button mBtnFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mBtnMeun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    isOpen = true;
                    ViewAnimator.animate(mBtnOne).dp().translationY(0, -200).duration(600).translationX(0, -100)
                            .andAnimate(mBtnTwo).dp().translationY(0, -100).translationX(0, -150)
                            .andAnimate(mBtnThree).dp().translationY(0, -100)
                            .andAnimate(mBtnFour).dp().translationY(0, -200)
                            .andAnimate(mBtnFive).dp().translationX(0, -200)
                            .andAnimate(mBtnMeun).rotation(45)
                            .thenAnimate(mBtnOne, mBtnTwo, mBtnThree, mBtnFour, mBtnMeun).wave()
                            .descelerate().start();
                } else {
                    isOpen = false;
                    ViewAnimator.animate(mBtnOne).dp().translationY(-200, 0).duration(600).translationX(-100, 0)
                            .andAnimate(mBtnTwo).dp().translationY(-100, 0).translationX(-150, 0)
                            .andAnimate(mBtnThree).dp().translationY(-100, 0)
                            .andAnimate(mBtnFour).dp().translationY(-200, 0)
                            .andAnimate(mBtnFive).dp().translationX(-200, 0)
                            .andAnimate(mBtnMeun).rotation(0).shake()
                            .accelerate().start();

                }
            }
        });


    }

    @Override
    protected MainPresent createPresenter() {
        return new MainPresent();
    }

}
