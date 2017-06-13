package com.example.yokomii.architecturecomponents.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.yokomii.architecturecomponents.R
import com.example.yokomii.architecturecomponents.ui.searchPhoto.SearchPhotoFragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * メインアクティビティ
 */
class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState ?: supportFragmentManager.beginTransaction()
                .add(R.id.container, SearchPhotoFragment())
                .commit()
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
