package com.jhlee.android.apptemplate.dagger.components;

import com.jhlee.android.apptemplate.dagger.modules.ActivityModule;
import com.jhlee.android.apptemplate.dagger.scopes.PerActivity;
import com.jhlee.android.apptemplate.view.home.HomeActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface HomeActivityComponent extends ActivityComponent {
    void inject(HomeActivity activity);
}
