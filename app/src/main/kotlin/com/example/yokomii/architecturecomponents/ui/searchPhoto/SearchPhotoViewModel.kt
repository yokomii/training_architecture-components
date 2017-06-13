package com.example.yokomii.architecturecomponents.ui.searchPhoto

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.example.yokomii.architecturecomponents.api.MyService
import com.example.yokomii.architecturecomponents.vo.SearchPublicResponse
import javax.inject.Inject

/**
 * [SearchPhotoFragment]用[ViewModel]
 */
class SearchPhotoViewModel @Inject constructor(private val myService: MyService) : ViewModel() {

    private val query = MutableLiveData<String>()

    val model: LiveData<SearchPublicResponse>
            = Transformations.switchMap(query) { myService.searchPublic(it) }

    fun searchPhoto(query: String) {
        this.query.value = query
    }
}
