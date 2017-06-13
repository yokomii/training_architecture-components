package com.example.yokomii.architecturecomponents.api

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * アプリ用[CallAdapter]
 * [Call]を[LiveData]に変換する
 */
class MyCallAdapter(private val responseType: Type) : CallAdapter<Any, LiveData<*>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<Any>) = ApiLiveData(call)
}
