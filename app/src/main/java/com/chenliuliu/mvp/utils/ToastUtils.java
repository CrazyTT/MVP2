package com.chenliuliu.mvp.utils;

import android.os.Handler;
import android.widget.Toast;
import com.chenliuliu.mvp.app.MyApplication;


public class ToastUtils {

    public static final int LENGTH_SHORT = android.widget.Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = android.widget.Toast.LENGTH_LONG;

    private static android.widget.Toast toast;
    private static Handler handler = new Handler();

    private static Runnable run = new Runnable() {
        public void run() {
            toast.cancel();
        }
    };

    /**
     * <p/>
     *
     * @param msg
     * @param duration
     * @author chenliuliu, 2014-9-15
     */
    public static void toast(CharSequence msg, int duration) {
        handler.removeCallbacks(run);
        switch (duration) {
            case LENGTH_SHORT:
                duration = Toast.LENGTH_SHORT;
                break;
            case LENGTH_LONG:
                duration = Toast.LENGTH_LONG;
                break;
            default:
                break;
        }
        if (null != toast) {
            toast.setText(msg);
        } else {
            toast = android.widget.Toast.makeText(MyApplication.getInstance(), msg, duration);
        }
        handler.postDelayed(run, duration);
        toast.show();
    }
}
