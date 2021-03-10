package com.animesh.roy.daggerpractice.di;

import com.animesh.roy.daggerpractice.BaseApplication;
import com.animesh.roy.daggerpractice.di.users.UserItemsViewModelModule;
import com.animesh.roy.daggerpractice.ui.useritems.UserItemsActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                ViewModelFactoryModule.class,
                RetrofitModule.class,
                UserItemsViewModelModule.class
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {
    public void inject(UserItemsActivity userItemsActivity);
}
