package com.jhlee.android.apptemplate.dagger.modules;

import com.jhlee.android.apptemplate.view.home.TalkListView;

import dagger.Module;
import dagger.Provides;

@Module
public class TalkListMvpViewModule {

    private final TalkListView view;

    public TalkListMvpViewModule(TalkListView view) {
        this.view = view;
    }

    @Provides
    TalkListView provideMvpView() {
        return view;
    }
}
