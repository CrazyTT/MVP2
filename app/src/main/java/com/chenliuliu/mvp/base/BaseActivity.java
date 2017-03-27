package com.chenliuliu.mvp.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * 这边可以重写自己的一些base的东西
 */
public class BaseActivity extends AppCompatActivity {
    public Context context;

    private SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        //initBarTint();
        //initTopBar();
    }


    private void initBarTint() {
        mTintManager = new SystemBarTintManager(this);
        mTintManager.setStatusBarTintEnabled(true);
        mTintManager.setNavigationBarTintEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // 全透明
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else {
                setTranslucentStatus(window);
            }
        }
        setTintResource(getTintResourceId());
    }

//    private void initTopBar() {
//        // 4.4以上设置头部导航高度
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            View topBar = findViewById(R.id.activity_top_bar);
//            if (topBar == null) {
//                return;
//            }
//            SystemBarTintManager.SystemBarConfig config = new SystemBarTintManager(this).getConfig();
//            int statusBarHeight = config.getStatusBarHeight();
//            topBar.setPadding(0, statusBarHeight, 0, 0);
//
//            int height = topBar.getLayoutParams().height;
//            topBar.getLayoutParams().height = statusBarHeight + height;
//        }
//    }

    @TargetApi(19)
    private void setTranslucentStatus(Window window) {
        WindowManager.LayoutParams winParams = window.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        winParams.flags |= bits;
        window.setAttributes(winParams);
    }

    protected void setTintResource(int res) {
        mTintManager.setTintResource(res);
    }

    protected int getTintResourceId() {
        return android.R.color.transparent;
    }

}
