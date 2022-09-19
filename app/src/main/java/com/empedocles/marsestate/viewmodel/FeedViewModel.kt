package com.empedocles.marsestate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.empedocles.marsestate.model.Estate
import com.empedocles.marsestate.service.EstateAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    private val service = EstateAPIService()

    val loading = MutableLiveData<Boolean>()
    val estates = MutableLiveData<List<Estate>>()

    // RxJava implementation
    // Get data with retrofit
    fun getFromApi() {
        loading.value = true

        disposable.add(
            service.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Estate>>() {
                    override fun onSuccess(t: List<Estate>) {
                        loading.value = false
                        estates.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        loading.value = false
                    }
                })
        )
    }

}