package com.animesh.roy.daggerpractice;

import com.animesh.roy.daggerpractice.di.AppComponent;
import com.animesh.roy.daggerpractice.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    public AppComponent appComponent;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        appComponent = DaggerAppComponent.builder().build();
        return appComponent;
    }

}