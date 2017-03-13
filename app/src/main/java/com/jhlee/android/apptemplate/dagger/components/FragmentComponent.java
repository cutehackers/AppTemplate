package com.jhlee.android.apptemplate.dagger.components;

import android.support.v4.app.Fragment;

import com.jhlee.android.apptemplate.dagger.modules.FragmentModule;
import com.jhlee.android.apptemplate.dagger.scopes.PerFragment;
import com.jhlee.android.apptemplate.base.BaseFragment;

import dagger.Component;

@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(BaseFragment fragment);

    Fragment fragment();
}
