package com.example.yokomii.architecturecomponents.di

import com.example.yokomii.architecturecomponents.ui.searchPhoto.SearchPhotoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * FragmentBuildersモジュール
 */
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSearchPhotoFragment(): SearchPhotoFragment
}
