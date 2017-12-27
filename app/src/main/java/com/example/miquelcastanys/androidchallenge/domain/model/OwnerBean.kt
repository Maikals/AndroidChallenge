package com.example.miquelcastanys.androidchallenge.domain.model

import android.os.Parcel
import android.os.Parcelable

data class OwnerBean(val login: String? = null,
                     val id: Int = 0,
                     val avatar_url: String? = null,
                     val gravatar_id: String? = null,
                     val url: String? = null,
                     val html_url: String? = null,
                     val followers_url: String? = null,
                     val following_url: String? = null,
                     val gists_url: String? = null,
                     val starred_url: String? = null,
                     val subscriptions_url: String? = null,
                     val organizations_url: String? = null,
                     val repos_url: String? = null,
                     val events_url: String? = null,
                     val received_events_url: String? = null,
                     val type: String? = null,
                     val isSite_admin: Boolean = false) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            1 == source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(login)
        writeInt(id)
        writeString(avatar_url)
        writeString(gravatar_id)
        writeString(url)
        writeString(html_url)
        writeString(followers_url)
        writeString(following_url)
        writeString(gists_url)
        writeString(starred_url)
        writeString(subscriptions_url)
        writeString(organizations_url)
        writeString(repos_url)
        writeString(events_url)
        writeString(received_events_url)
        writeString(type)
        writeInt((if (isSite_admin) 1 else 0))
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<OwnerBean> = object : Parcelable.Creator<OwnerBean> {
            override fun createFromParcel(source: Parcel): OwnerBean = OwnerBean(source)
            override fun newArray(size: Int): Array<OwnerBean?> = arrayOfNulls(size)
        }
    }
}