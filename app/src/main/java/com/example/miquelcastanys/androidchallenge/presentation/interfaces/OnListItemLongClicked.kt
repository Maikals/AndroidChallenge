package com.example.miquelcastanys.androidchallenge.presentation.interfaces


interface OnListItemLongClicked {
    interface Adapter {
        fun onItemLongClick(position: Int)
    }
    interface View {
        fun onItemLongClick(position: Int)
    }
}