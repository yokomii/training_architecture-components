package com.example.yokomii.architecturecomponents.api

import android.arch.lifecycle.LiveData
import com.example.yokomii.architecturecomponents.vo.SearchPublicResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * APIサービス
 */
interface MyService {

    @GET("rest/search_public.json")
    fun searchPublic(
            @Query("keyword") keyword: String
    ): LiveData<SearchPublicResponse>
}
