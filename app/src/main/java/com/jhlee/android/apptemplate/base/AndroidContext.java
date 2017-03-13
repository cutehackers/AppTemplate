package com.jhlee.android.apptemplate.base;

import android.support.annotation.NonNull;

import com.jhlee.android.apptemplate.MyApplication;
import com.jhlee.android.apptemplate.dagger.components.AppComponent;

public class AndroidContext {

    private static AndroidContext sInstance;

    private final MyApplication mApplication;


    private AndroidContext(MyApplication application) {
        mApplication = application;
    }

    static void initialize(@NonNull MyApplication application) {
        sInstance = new AndroidContext(application);
    }

    public static AndroidContext instance() {
        if (sInstance == null) {
            throw new IllegalStateException("Android context was not initialized.");
        }
        return sInstance;
    }

    public MyApplication getApplication() {
        return mApplication;
    }

    public AppComponent getAppComponent() {
        return mApplication.getAppComponent();
    }
}
