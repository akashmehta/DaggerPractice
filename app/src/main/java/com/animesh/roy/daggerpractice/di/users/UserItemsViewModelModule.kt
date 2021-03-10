package com.animesh.roy.daggerpractice.di.users

import androidx.lifecycle.ViewModel
import com.animesh.roy.daggerpractice.di.ViewModelKey
import com.animesh.roy.daggerpractice.ui.useritems.UserItemsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
public abstract class UserItemsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserItemsViewModel::class)
    public abstract fun bindUserItemsViewModel(viewModel: UserItemsViewModel) : ViewModel
}