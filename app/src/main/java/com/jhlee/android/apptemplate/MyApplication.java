package com.jhlee.android.apptemplate;

import android.support.multidex.MultiDexApplication;

import com.jhlee.android.apptemplate.base.AndroidContext;
import com.jhlee.android.apptemplate.dagger.components.AppComponent;
import com.jhlee.android.apptemplate.dagger.components.DaggerAppComponent;
import com.jhlee.android.apptemplate.dagger.modules.AppModule;
import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends MultiDexApplication {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidContext.initialize(this);

        setUpInjector();
        setUpLeakCanary();
    }

    private void setUpInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void setUpLeakCanary() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
