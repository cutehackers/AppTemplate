package com.jhlee.android.apptemplate.dagger.modules;

import android.support.v4.app.Fragment;

import com.jhlee.android.apptemplate.dagger.scopes.PerFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment provideFragment() {
        return this.fragment;
    }
}
