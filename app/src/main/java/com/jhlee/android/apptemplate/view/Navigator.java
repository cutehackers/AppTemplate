package com.jhlee.android.apptemplate.view;

import android.content.Context;
import android.content.Intent;

import com.jhlee.android.apptemplate.view.home.HomeActivity;

import javax.inject.Singleton;

@Singleton
public class Navigator {

    public Navigator() {

    }

    public void navigateToHomeActivityView(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, HomeActivity.class));
        }
    }
}
