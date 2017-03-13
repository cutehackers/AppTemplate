package com.jhlee.android.apptemplate.base;

import android.support.v4.app.Fragment;

import com.jhlee.android.apptemplate.dagger.HasComponent;

public abstract class BaseFragment extends Fragment {

    @SuppressWarnings("unchecked")
    protected <C> C getActivityComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
