package com.animesh.roy.daggerpractice.ui.useritems;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.animesh.roy.daggerpractice.BaseApplication;
import com.animesh.roy.daggerpractice.R;
import com.animesh.roy.daggerpractice.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class UserItemsActivity extends DaggerAppCompatActivity {

    private UserItemsViewModel userViewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_items);
        ( (BaseApplication) getApplication()).appComponent.inject(this);
        userViewModel = new ViewModelProvider(this, viewModelProviderFactory).get(UserItemsViewModel.class);
        setupApi();
    }

    private void setupApi() {

        userViewModel.getLiveData().observe(this, arrayListCommonApiUiModel -> {
            if (arrayListCommonApiUiModel.getResponse() != null) {
                RecyclerView rvUserItem = findViewById(R.id.rvUserItems);
                rvUserItem.setLayoutManager(new LinearLayoutManager(UserItemsActivity.this));
                rvUserItem.setAdapter(new UserItemsListAdapter(arrayListCommonApiUiModel.getResponse()));
            }
        });
        userViewModel.fetchUsers();
    }
}