package com.jhlee.android.apptemplate.dagger.components;

import com.jhlee.android.apptemplate.dagger.modules.FragmentModule;
import com.jhlee.android.apptemplate.dagger.modules.TalkListMvpViewModule;
import com.jhlee.android.apptemplate.dagger.scopes.PerFragment;
import com.jhlee.android.apptemplate.view.home.TalkListView;
import com.jhlee.android.apptemplate.view.home.TalkListFragment;

import dagger.Component;

@PerFragment
@Component(dependencies = AppComponent.class, modules = {FragmentModule.class, TalkListMvpViewModule.class})
public interface TalkListFragmentComponent extends FragmentComponent {
    void inject(TalkListFragment fragment);

    TalkListView getMvpView();
}
