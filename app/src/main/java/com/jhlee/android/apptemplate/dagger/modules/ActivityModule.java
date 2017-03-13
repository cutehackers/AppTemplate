package com.jhlee.android.apptemplate.dagger.modules;

import android.app.Activity;

import com.jhlee.android.apptemplate.dagger.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return this.activity;
    }
}
