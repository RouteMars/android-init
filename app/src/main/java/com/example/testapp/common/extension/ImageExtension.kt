package com.example.testapp.common.extension

import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.testapp.R

fun ImageView.loadImage(url: String?) {
    this.load(url) {
        crossfade(true)
        placeholder(R.mipmap.ic_launcher_round)
        transformations(CircleCropTransformation())
    }
    // Glide
    //    val options = RequestOptions()
    //        .error(R.mipmap.ic_launcher_round)
    //    Glide.with(this.context)
    //        .setDefaultRequestOptions(options)
    //        .load(uri)
    //        .into(this)
}