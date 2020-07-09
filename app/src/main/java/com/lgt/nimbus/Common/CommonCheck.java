package com.lgt.nimbus.Common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

public class CommonCheck {
    private final Context _context;

    public CommonCheck(Context context) {
        _context = context;
    }

    public static void changeStatusBarColor(String color, Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }

//    public static boolean isConnectingToInternet() {
//        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (connectivity != null) {
//            NetworkInfo[] info = connectivity.getAllNetworkInfo();
//            if (info != null)
//                for (NetworkInfo anInfo : info)
//                    if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
//                        return true;
//                    }
//
//        }
//        return false;
//    }
}
