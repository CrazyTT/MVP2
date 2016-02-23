package com.chenliuliu.mvp.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chenliuliu.mvp.R;
import com.chenliuliu.mvp.base.MvpActivity;
import com.chenliuliu.mvp.present.LoginPresent;
import com.chenliuliu.mvp.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;

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

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.app_name));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
        QQ.ShareParams sp = new QQ.ShareParams();
        sp.setText("");
        sp.setImagePath("");


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
