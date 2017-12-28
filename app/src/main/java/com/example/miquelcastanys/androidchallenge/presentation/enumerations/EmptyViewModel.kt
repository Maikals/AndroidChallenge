package com.example.miquelcastanys.androidchallenge.presentation.enumerations

import com.example.miquelcastanys.androidchallenge.R


enum class EmptyViewModel(var imageId: Int, var title: Int, var subtitle: Int) {
    ERROR(R.drawable.github, R.string.error_empty_view_title, R.string.error_empty_view_description)
}