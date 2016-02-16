package com.chenliuliu.mvp.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

/**
 * Created by liuliuchen on 16/2/16.
 */
public final class ToastUtils {
    public static int CONSTANT_DURA = Toast.LENGTH_SHORT;

    /**
     * Find text from resourse and show into toast message
     *
     * @param activity          {@link Activity} used to create the {@link Toast} message
     * @param messageResourceId The resource containing the message to be displayed
     */
    public static void show(final Activity activity, final int messageResourceId) {
        ToastUtils.show(activity, messageResourceId, ToastUtils.CONSTANT_DURA);
    }

    /**
     * Find text from resourse and show into toast message with custome time
     *
     * @param activity          {@link Activity} used to create the {@link Toast} message
     * @param messageResourceId The resource containing the message to be displayed
     * @param duration          How long to display the message. Either
     *                          {@link Toast#LENGTH_SHORT} or {@link Toast#LENGTH_LONG}
     */
    public static void show(final Activity activity,
                            final int messageResourceId, final int duration) {
        ToastUtils.showToast(activity, activity.getString(messageResourceId),
                null, duration);
    }

    /**
     * Toast directly pass string to file to an argument
     *
     * @param activity {@link Activity} used to create the {@link Toast} message
     * @param message  The message to be displayed
     */
    public static void show(final Activity activity, final String message) {
        ToastUtils.show(activity, message, ToastUtils.CONSTANT_DURA);
    }

    /**
     * Toast directly pass string to file to an argument with custom
     * {@link Toast} message
     *
     * @param activity {@link Activity} used to create the {@link Toast} message
     * @param message  The message to be displayed
     * @param duration How long to display the message. Either
     *                 {@link Toast#LENGTH_SHORT} or {@link Toast#LENGTH_LONG}
     */
    public static void show(final Activity activity, final String message,
                            final int duration) {
        ToastUtils.showToast(activity, message, null, duration);
    }

    /**
     * Make a standard toast that displays a {@link View}.
     *
     * @param activity {@link Activity} used to create the {@link Toast} message
     * @param view     The {@link View} to show
     */
    public static void show(final Activity activity, final View view) {
        ToastUtils.show(activity, view, ToastUtils.CONSTANT_DURA);
    }

    /**
     * Make a standard toast that displays a {@link View}.
     *
     * @param activity {@link Activity} used to create the {@link Toast} message
     * @param view     The {@link View} to show
     * @param duration How long to display the message. Either
     *                 {@link Toast#LENGTH_SHORT} or {@link Toast#LENGTH_LONG}
     */
    public static void show(final Activity activity, final View view,
                            final int duration) {
        ToastUtils.showToast(activity, null, view, duration);
    }

    /**
     * @param activity {@link Activity} used to create the {@link Toast} message.
     * @param message  The message to be displayed.
     * @param view     The {@link View} to be displayed.
     * @param duration How long to display the message. Either
     *                 {@link Toast#LENGTH_SHORT} or {@link Toast#LENGTH_LONG}.
     */
    private static void showToast(final Activity activity,
                                  final String message, final View view, final int duration) {
        if (activity == null) {
            return;
        }
        if (TextUtils.isEmpty(message) && view == null) {
            return;
        }

        final Context context = activity.getApplicationContext();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final Toast toast = Toast.makeText(context, message, duration);

                if (view != null) {
                    toast.setView(view);
                }
                toast.show();
            }
        });
    }
}
