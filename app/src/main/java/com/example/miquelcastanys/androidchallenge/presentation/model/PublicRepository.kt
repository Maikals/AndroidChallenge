package com.example.miquelcastanys.androidchallenge.presentation.model

import android.os.Parcel
import android.os.Parcelable
import com.example.miquelcastanys.androidchallenge.presentation.utils.Constants


data class PublicRepository(val name: String? = null,
                            val description: String? = null,
                            val login: String? = null,
                            val forkFlag: Boolean? = null,
                            val ownerUrl: String? = null,
                            val repositoryUrl: String? = null,
                            val type: Int = Constants.PUBLIC_REPOSITORY_TYPE) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readString(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(description)
        writeString(login)
        writeValue(forkFlag)
        writeString(ownerUrl)
        writeString(repositoryUrl)
        writeInt(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PublicRepository> = object : Parcelable.Creator<PublicRepository> {
            override fun createFromParcel(source: Parcel): PublicRepository = PublicRepository(source)
            override fun newArray(size: Int): Array<PublicRepository?> = arrayOfNulls(size)
        }
    }
}