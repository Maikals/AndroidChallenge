package com.example.miquelcastanys.androidchallenge.presentation.enumerations

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import com.example.miquelcastanys.androidchallenge.R


enum class EmptyViewModel(@DrawableRes val imageId: Int, @StringRes val title: Int, @StringRes val subtitle: Int) {
    ERROR(R.drawable.github, R.string.error_empty_view_title, R.string.error_empty_view_description),
    EMPTY(R.drawable.github, R.string.no_elements_emtpy_view_title, R.string.no_elements_emtpy_view_description)
}