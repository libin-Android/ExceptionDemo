package com.example.administrator.exceptiondemo;

import android.app.Application;

import crashException.CrashHandler;

/**
 * Created by Administrator on 2016/10/20.
 */
public class MyApplicatoin extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler=CrashHandler.getInstance();
        crashHandler.init();
    }
}
