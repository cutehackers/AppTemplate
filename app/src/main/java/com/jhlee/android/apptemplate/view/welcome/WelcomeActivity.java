package com.jhlee.android.apptemplate.view.welcome;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.jhlee.android.apptemplate.R;
import com.jhlee.android.apptemplate.base.BaseActivity;
import com.jhlee.android.apptemplate.dagger.HasComponent;
import com.jhlee.android.apptemplate.dagger.components.ActivityComponent;
import com.jhlee.android.apptemplate.dagger.components.DaggerActivityComponent;
import com.jhlee.android.apptemplate.dagger.modules.ActivityModule;

public class WelcomeActivity extends BaseActivity implements HasComponent<ActivityComponent> {

    private ActivityComponent component;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);

        setContentView(R.layout.activity_welcome);

        handler.postDelayed(homeViewNavigator, 1000);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(homeViewNavigator);
        super.onDestroy();
    }

    @Override
    public ActivityComponent getComponent() {
        if (component == null) {
            component = DaggerActivityComponent.builder()
                    .appComponent(getAppComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return component;
    }

    private final Runnable homeViewNavigator = new Runnable() {
        @Override
        public void run() {
            getAppComponent().navigator().navigateToHomeActivityView(WelcomeActivity.this);
            finish();
        }
    };
}
