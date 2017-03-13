package com.jhlee.android.apptemplate.base;

import android.support.v7.app.AppCompatActivity;

import com.jhlee.android.apptemplate.MyApplication;
import com.jhlee.android.apptemplate.dagger.components.AppComponent;

public abstract class BaseActivity extends AppCompatActivity {

    protected AppComponent getAppComponent() {
        return ((MyApplication) getApplication()).getAppComponent();
    }
}
