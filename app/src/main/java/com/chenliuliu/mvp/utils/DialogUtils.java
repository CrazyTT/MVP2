package com.chenliuliu.mvp.utils;

import android.content.Context;

import com.chenliuliu.mvp.utils.mydialog.MyProgressDialog;

/**
 * Created by liuliuchen on 16/2/16.
 */
public class DialogUtils {

    private MyProgressDialog myProgressDialog;

    private volatile static DialogUtils instance;

    public static DialogUtils getInstance() {
        if (null == instance) {
            synchronized (MyProgressDialog.class) {
                if (null == instance) {
                    instance = new DialogUtils();
                }
            }
        }
        return instance;
    }

    public void show(Context context) {
        myProgressDialog = MyProgressDialog.create(context).setCancellable(false).setCanceledOnTouchOutside(false)
                .setStyle(MyProgressDialog.Style.SPIN_INDETERMINATE);
        myProgressDialog.show();
    }

    public void show(Context context, String str) {
        myProgressDialog = MyProgressDialog.create(context).setCancellable(false).setDimAmount(0.5f).setLabel(str)
                .setStyle(MyProgressDialog.Style.SPIN_INDETERMINATE);
        myProgressDialog.show();
    }

    public void dismiss() {
        if (myProgressDialog != null && myProgressDialog.isShowing()) {
            myProgressDialog.dismiss();
        }
        myProgressDialog = null;
    }

}
