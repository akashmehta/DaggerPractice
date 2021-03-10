package com.animesh.roy.daggerpractice.di;

import com.animesh.roy.daggerpractice.ui.useritems.UserItemsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract UserItemsActivity contributeUserItemsActivity();
}
