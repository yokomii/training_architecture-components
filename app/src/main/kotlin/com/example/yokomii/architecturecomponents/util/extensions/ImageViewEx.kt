package com.example.yokomii.architecturecomponents.util.extensions

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * [ImageView]の拡張関数群
 */

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String){
    Picasso.with(this.context).load(url).into(this)
}
