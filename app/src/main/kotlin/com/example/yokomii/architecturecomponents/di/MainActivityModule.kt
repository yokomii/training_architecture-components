package com.example.yokomii.architecturecomponents.di

import com.example.yokomii.architecturecomponents.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * [MainActivity]コンポーネント
 */
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    abstract fun contributeMainActivity(): MainActivity
}
