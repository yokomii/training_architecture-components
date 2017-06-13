package com.example.yokomii.architecturecomponents.api

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * アプリ用[CallAdapter.Factory]
 */
class MyCallAdapterFactory : CallAdapter.Factory() {

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit) =
            MyCallAdapter(getParameterUpperBound(0, returnType as ParameterizedType))
}
