package com.example.miquelcastanys.androidchallenge.presentation.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.example.miquelcastanys.androidchallenge.R
import com.example.miquelcastanys.androidchallenge.presentation.base.BaseDialog


class UrlDialog : BaseDialog() {

    companion object {
        const val TAG = "UrlDialog"
        const val RESULT_REPOSITORY: Int = 1
        const val RESULT_OWNER: Int = 2
        const val POSITION: String = "position"

        fun newInstance(position: Int): UrlDialog {
            val bundle = Bundle()
            bundle.putInt(POSITION, position)
            val urlDialog = UrlDialog()
            urlDialog.arguments = bundle
            return urlDialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val position = arguments.getInt(POSITION)
        return AlertDialog.Builder(activity)
                .setTitle(getString(R.string.url_dialog_title))
                .setPositiveButton(getString(R.string.repository_button), { _, _ ->
                    targetFragment.onActivityResult(targetRequestCode, RESULT_REPOSITORY, createIntent(position))
                })
                .setNegativeButton(getString(R.string.owner_button), { _, _ ->
                    targetFragment.onActivityResult(targetRequestCode, RESULT_OWNER, createIntent(position))
                })
                .setNeutralButton(android.R.string.cancel, { _, _ ->
                    targetFragment.onActivityResult(targetRequestCode, Activity.RESULT_CANCELED, activity.intent)
                })
                .create()
    }

    private fun createIntent(position: Int): Intent {
        val intent = Intent()
        intent.putExtra(POSITION, position)
        return intent
    }
}