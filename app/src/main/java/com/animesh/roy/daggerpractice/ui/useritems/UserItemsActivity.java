package com.animesh.roy.daggerpractice.ui.useritems;

import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aakash.androidmadsampleproject.usermodule.ui.UserItemsListAdapter;
import com.animesh.roy.daggerpractice.R;
import com.animesh.roy.daggerpractice.apiintegration.ApiEndPoint;
import com.animesh.roy.daggerpractice.apiintegration.CommonApiUiModel;
import com.animesh.roy.daggerpractice.viewmodels.ViewModelProviderFactory;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class UserItemsActivity extends DaggerAppCompatActivity {

    private UserItemsViewModel userViewModel;

    @Inject
    ApiEndPoint apiEndPoint;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_items);
        userViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(UserItemsViewModel.class);
        setupApi();
    }

    private void setupApi() {

        userViewModel.getLiveData().observe(this, new Observer<CommonApiUiModel<ArrayList<UserItemResponse>>>() {
            @Override
            public void onChanged(CommonApiUiModel<ArrayList<UserItemResponse>> arrayListCommonApiUiModel) {
                if (arrayListCommonApiUiModel.getResponse() != null) {
                    RecyclerView rvUserItem = findViewById(R.id.rvUserItems);
                    rvUserItem.setLayoutManager(new LinearLayoutManager(UserItemsActivity.this));
                    rvUserItem.setAdapter(new UserItemsListAdapter(arrayListCommonApiUiModel.getResponse()));
                }
            }
        });
        userViewModel.fetchUsers(apiEndPoint);
    }
}