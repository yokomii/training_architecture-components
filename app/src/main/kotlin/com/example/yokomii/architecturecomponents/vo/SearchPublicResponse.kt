package com.example.yokomii.architecturecomponents.vo

/**
 * API(search_public)レスポンス
 */
data class SearchPublicResponse(
        val stat: String,
        val info: Photos,
        val err: Err?
)
