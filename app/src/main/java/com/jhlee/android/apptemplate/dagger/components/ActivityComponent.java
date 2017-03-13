package com.jhlee.android.apptemplate.dagger.components;

import android.app.Activity;

import com.jhlee.android.apptemplate.dagger.modules.ActivityModule;
import com.jhlee.android.apptemplate.dagger.scopes.PerActivity;
import com.jhlee.android.apptemplate.base.BaseActivity;
import com.jhlee.android.apptemplate.base.BaseFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity activity);
    void inject(BaseFragment fragment);

    Activity activity();
}
