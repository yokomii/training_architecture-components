package com.example.yokomii.architecturecomponents.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v4.util.ArrayMap
import com.example.yokomii.architecturecomponents.di.ViewModelSubComponent
import com.example.yokomii.architecturecomponents.ui.searchPhoto.SearchPhotoViewModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * ViewModelにInjectionを行うためのファクトリークラス
 */
@Singleton
class MyViewModelFactory @Inject constructor(viewModelSubComponent: ViewModelSubComponent) : ViewModelProvider.Factory {

    private val creators = ArrayMap<Class<out ViewModel>, () -> ViewModel>().apply {
        put(SearchPhotoViewModel::class.java, { viewModelSubComponent.searchPhotoViewModel() })
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = creators[modelClass]?.invoke() as T
}
