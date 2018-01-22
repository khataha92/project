package com.webteb.webtebapp.Utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;

import com.webteb.webtebapp.Interfaces.AbstractCallback;
import com.webteb.webtebapp.R;
import com.webteb.webtebapp.ThisApp;

/**
 * Created by khalid on 1/19/18.
 */

public class UIUtils {

    public static void showRetryDialog(String title, String message, final AbstractCallback onDismiss, final AbstractCallback onRetry) {

        new AlertDialog.Builder(ThisApp.getCurrentActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(AppUtil.getString(R.string.RETRY), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (onRetry != null) {

                            onRetry.onResult(true, null);
                        }
                    }
                })
                .setNegativeButton(AppUtil.getString(R.string.CANCEL), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (onDismiss != null) {

                            onDismiss.onResult(true, null);
                        }
                    }
                })
                .show();

    }

    public static void runOnNonUiThread(Runnable runnable) {

        Thread thread = new Thread(runnable);

        thread.start();
    }

    public static void runOnUiThread(Runnable runnable) {

        if (ThisApp.getCurrentActivity() == null) {

            return;

        }

        ThisApp.getCurrentActivity().runOnUiThread(runnable);
    }


    public static int dpToPx(float dp) {

        float resultPix = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ThisApp.getContext().getResources().getDisplayMetrics());

        return (int) resultPix;
    }

    public static void showLoadingView(View view) {

        if (view == null || !(view instanceof ViewGroup)) {

            return;
        }

        View loadingView = view.findViewById(R.id.loadingView);

        if (loadingView == null) {

            loadingView = LayoutInflater.from(ThisApp.getContext()).inflate(R.layout.loading_view, null);

            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            loadingView.setLayoutParams(params);

            ((ViewGroup) view).addView(loadingView);

        }
    }

    public static void hideLoadingView(View view) {

        if (view == null || !(view instanceof ViewGroup)) {

            return;
        }

        View loadingView = view.findViewById(R.id.loadingView);

        if (loadingView == null) {

            return;
        }

        ((ViewGroup) view).removeView(loadingView);

    }


}
