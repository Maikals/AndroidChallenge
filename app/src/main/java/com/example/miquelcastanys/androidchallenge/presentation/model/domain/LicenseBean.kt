package com.example.miquelcastanys.androidchallenge.presentation.model.domain

import android.os.Parcel
import android.os.Parcelable

data class LicenseBean(val key: String? = null,
                       val name: String? = null,
                       val spdx_id: String? = null,
                       val url: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(key)
        writeString(name)
        writeString(spdx_id)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LicenseBean> = object : Parcelable.Creator<LicenseBean> {
            override fun createFromParcel(source: Parcel): LicenseBean = LicenseBean(source)
            override fun newArray(size: Int): Array<LicenseBean?> = arrayOfNulls(size)
        }
    }
}