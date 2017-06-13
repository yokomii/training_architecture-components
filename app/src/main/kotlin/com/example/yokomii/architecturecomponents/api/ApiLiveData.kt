package com.example.yokomii.architecturecomponents.api

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.atomic.AtomicBoolean

/**
 * APIのレスポンス値をPostする[LiveData]
 */
class ApiLiveData<T>(private val call: Call<T>) : LiveData<T>() {

    private val started = AtomicBoolean(false)

    override fun onActive() {
        super.onActive()

        if (started.compareAndSet(false, true)) {

            call.enqueue(object : Callback<T> {

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    response.body()?.let { postValue(it) }
                }

                override fun onFailure(call: Call<T>, throwable: Throwable) {
                    // TODO エラー時の処理
                }
            })
        }
    }
}
