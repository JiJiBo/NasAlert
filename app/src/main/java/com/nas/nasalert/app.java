package com.nas.nasalert;

import android.app.Application;
import android.os.Handler;

import com.rulerbug.bugutils.Utils.BugApp;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BugApp.init(this, new Handler(), android.os.Process.myTid());
        BGASwipeBackHelper.init(this, null);
    }
}
