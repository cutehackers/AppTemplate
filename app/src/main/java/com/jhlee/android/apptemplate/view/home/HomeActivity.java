package com.jhlee.android.apptemplate.view.home;

import android.os.Bundle;

import com.jhlee.android.apptemplate.R;
import com.jhlee.android.apptemplate.base.BaseActivity;
import com.jhlee.android.apptemplate.dagger.HasComponent;
import com.jhlee.android.apptemplate.dagger.components.DaggerHomeActivityComponent;
import com.jhlee.android.apptemplate.dagger.components.HomeActivityComponent;
import com.jhlee.android.apptemplate.dagger.modules.ActivityModule;

public class HomeActivity extends BaseActivity implements HasComponent<HomeActivityComponent> {

    private HomeActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);

        setContentView(R.layout.activity_home);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_home, new TalkListFragment())
                    .commit();
        }
    }

    @Override
    public HomeActivityComponent getComponent() {
        if (component == null) {
            component = DaggerHomeActivityComponent.builder()
                    .appComponent(getAppComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return component;
    }
}
