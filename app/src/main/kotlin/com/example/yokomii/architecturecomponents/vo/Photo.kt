package com.example.yokomii.architecturecomponents.vo

import java.util.*

/**
 * 写真
 */
data class Photo(
        val photoId: Long,
        val userId: Long,
        val albumId: Long,
        val photoTitle: String,
        val favoriteNum: Long,
        val comment_num: Long,
        val viewNum: Long,
        val copyright: String, //TODO: enum値を指定
        val copyrightCommercial: String, //TODO: enum値を指定
        val geo: Geo,
        val date: Date,
        val registTime: Date,
        val url: String,
        val imageUrl: String,
        val originalImageUrl: String,
        val thumbnailImageUrl: String,
        val largeTag: String,
        val mediumTag: String
)

