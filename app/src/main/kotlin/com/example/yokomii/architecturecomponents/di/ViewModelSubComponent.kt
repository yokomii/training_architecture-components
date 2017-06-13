package com.example.yokomii.architecturecomponents.di

import com.example.yokomii.architecturecomponents.ui.searchPhoto.SearchPhotoViewModel
import dagger.Subcomponent

/**
 * [ViewModel]用サブコンポーネント
 */
@Subcomponent
interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): ViewModelSubComponent
    }

    fun searchPhotoViewModel(): SearchPhotoViewModel
}
