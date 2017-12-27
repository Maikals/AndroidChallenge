package com.example.miquelcastanys.androidchallenge.presentation.customViews

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.miquelcastanys.androidchallenge.R
import com.example.miquelcastanys.androidchallenge.presentation.enumerations.EmptyViewModel


class EmptyViewComponent : FrameLayout {
    private var imageView: ImageView? = null
    private var titleTv: TextView? = null
    private var textTv: TextView? = null
    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    private fun init() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.generic_empty_view, this, true)
        imageView = findViewById(R.id.generic_empty_view_iv)
        titleTv = findViewById(R.id.generic_empty_view_title_tv)
        textTv = findViewById(R.id.generic_empty_view_text_tv)
    }
    fun fillViews(emptyViewModel: EmptyViewModel) {
        imageView!!.setImageDrawable(ContextCompat.getDrawable(context, emptyViewModel.imageId))
        titleTv!!.text = context.getString(emptyViewModel.title)
    }
}