package com.jhlee.android.apptemplate.dagger.components;

import android.app.Application;

import com.jhlee.android.apptemplate.dagger.modules.AppModule;
import com.jhlee.android.apptemplate.view.Navigator;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Application application();

    Navigator navigator();
}
