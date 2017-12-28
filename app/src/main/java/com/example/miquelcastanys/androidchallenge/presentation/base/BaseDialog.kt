package com.example.miquelcastanys.androidchallenge.presentation.base

import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager


open class BaseDialog : DialogFragment() {

    //Despliega el Dialog correspondiente al tag
    override fun show(fragmentManager: FragmentManager, tag: String) {
        if (fragmentManager.findFragmentByTag(tag) == null) {
            super.show(fragmentManager, tag)
        }
    }
}