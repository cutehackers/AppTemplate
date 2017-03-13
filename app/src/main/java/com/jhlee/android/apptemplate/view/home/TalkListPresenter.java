package com.jhlee.android.apptemplate.view.home;

import com.jhlee.android.apptemplate.dagger.scopes.PerFragment;
import com.jhlee.android.apptemplate.presenter.MvpPresenter;

import javax.inject.Inject;

@PerFragment
public class TalkListPresenter implements MvpPresenter {

    private TalkListView view;

    @Inject
    TalkListPresenter(TalkListView view) {
        this.view = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }


    public void onTalkClick(String message) {
        view.showTalkMessage(message);
    }
}
