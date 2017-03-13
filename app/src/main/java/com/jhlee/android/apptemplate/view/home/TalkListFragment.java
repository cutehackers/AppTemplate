package com.jhlee.android.apptemplate.view.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jhlee.android.apptemplate.base.AndroidContext;
import com.jhlee.android.apptemplate.R;
import com.jhlee.android.apptemplate.base.BaseFragment;
import com.jhlee.android.apptemplate.dagger.HasComponent;
import com.jhlee.android.apptemplate.dagger.components.DaggerTalkListFragmentComponent;
import com.jhlee.android.apptemplate.dagger.components.TalkListFragmentComponent;
import com.jhlee.android.apptemplate.dagger.modules.FragmentModule;
import com.jhlee.android.apptemplate.dagger.modules.TalkListMvpViewModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class TalkListFragment extends BaseFragment implements HasComponent<TalkListFragmentComponent>,
        TalkListView {

    private TalkListFragmentComponent component;

    @Inject
    TalkListPresenter presenter;


    public TalkListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("onCreate()");

        // case 1. injecting fragment into fragment component
        getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talk_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /**
         * case 2. injecting fragment into activity component
         *
         * onActivityCreated() is a proper injection point, if someone needs to inject this fragment
         * into activity component. activity component is going to be created from Activity's
         * Activity.onCreate() callback. so, we can implement here.
         *
         * ex) getActivityComponent(HomeActivityComponent.class).inject(this);
         */
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public TalkListFragmentComponent getComponent() {
        if (component == null) {
            component = DaggerTalkListFragmentComponent.builder()
                    .appComponent(AndroidContext.instance().getAppComponent())
                    .fragmentModule(new FragmentModule(this))
                    .talkListMvpViewModule(new TalkListMvpViewModule(this))
                    .build();
        }
        return component;
    }

    @Override
    public void showTalkMessage(String message) {
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(AndroidContext.instance().getApplication(), message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AndroidContext.instance().getApplication(), "empty talks", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.talk_button)
    void onTalkClick() {
        presenter.onTalkClick("model_data");
    }
}
