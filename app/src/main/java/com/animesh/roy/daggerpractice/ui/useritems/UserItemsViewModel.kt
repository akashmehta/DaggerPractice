package com.animesh.roy.daggerpractice.ui.useritems

import android.util.Pair
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.animesh.roy.daggerpractice.apiintegration.ApiEndPoint
import com.animesh.roy.daggerpractice.apiintegration.CommonApiUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList
import javax.inject.Inject

class UserItemsViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var apiService: ApiEndPoint

    private val compositeDisposable = CompositeDisposable()
    private val liveData = MutableLiveData<CommonApiUiModel<ArrayList<UserItemResponse>>>()

    fun getLiveData() = liveData

    fun fetchUsers() {
        liveData.value = CommonApiUiModel(progress = true)
        val disposable = apiService.fetchUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ itemList ->
                    liveData.value = CommonApiUiModel(response = itemList)
                }, {
                    liveData.value = CommonApiUiModel(error = Pair(-1, ""))
                })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
        super.onCleared()
    }
}