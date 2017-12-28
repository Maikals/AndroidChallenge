package com.example.miquelcastanys.androidchallenge.domain.model

import android.os.Parcel
import android.os.Parcelable

data class PublicRepositoriesResponse(val id: Int = 0,
                                      val name: String? = null,
                                      val full_name: String? = null,
                                      val owner: OwnerBean? = null,
                                      val isPrivateX: Boolean = false,
                                      val html_url: String? = null,
                                      val description: String? = null,
                                      val fork: Boolean = false,
                                      val url: String? = null,
                                      val forks_url: String? = null,
                                      val keys_url: String? = null,
                                      val collaborators_url: String? = null,
                                      val teams_url: String? = null,
                                      val hooks_url: String? = null,
                                      val issue_events_url: String? = null,
                                      val events_url: String? = null,
                                      val assignees_url: String? = null,
                                      val branches_url: String? = null,
                                      val tags_url: String? = null,
                                      val blobs_url: String? = null,
                                      val git_tags_url: String? = null,
                                      val git_refs_url: String? = null,
                                      val trees_url: String? = null,
                                      val statuses_url: String? = null,
                                      val languages_url: String? = null,
                                      val stargazers_url: String? = null,
                                      val contributors_url: String? = null,
                                      val subscribers_url: String? = null,
                                      val subscription_url: String? = null,
                                      val commits_url: String? = null,
                                      val git_commits_url: String? = null,
                                      val comments_url: String? = null,
                                      val issue_comment_url: String? = null,
                                      val contents_url: String? = null,
                                      val compare_url: String? = null,
                                      val merges_url: String? = null,
                                      val archive_url: String? = null,
                                      val downloads_url: String? = null,
                                      val issues_url: String? = null,
                                      val pulls_url: String? = null,
                                      val milestones_url: String? = null,
                                      val notifications_url: String? = null,
                                      val labels_url: String? = null,
                                      val releases_url: String? = null,
                                      val deployments_url: String? = null,
                                      val created_at: String? = null,
                                      val updated_at: String? = null,
                                      val pushed_at: String? = null,
                                      val git_url: String? = null,
                                      val ssh_url: String? = null,
                                      val clone_url: String? = null,
                                      val svn_url: String? = null,
                                      val homepage: String? = null,
                                      val size: Int = 0,
                                      val stargazers_count: Int = 0,
                                      val watchers_count: Int = 0,
                                      val language: String? = null,
                                      val isHas_issues: Boolean = false,
                                      val isHas_projects: Boolean = false,
                                      val isHas_downloads: Boolean = false,
                                      val isHas_wiki: Boolean = false,
                                      val isHas_pages: Boolean = false,
                                      val forks_count: Int = 0,
                                      val mirror_url: String? = null,
                                      val isArchived: Boolean = false,
                                      val open_issues_count: Int = 0,
                                      val license: LicenseBean? = null,
                                      val forks: Int = 0,
                                      val open_issues: Int = 0,
                                      val watchers: Int = 0,
                                      val default_branch: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readParcelable<OwnerBean>(OwnerBean::class.java.classLoader),
            1 == source.readInt(),
            source.readString(),
            source.readString(),
            1 == source.readInt(),
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
            source.readString(),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readString(),
            1 == source.readInt(),
            1 == source.readInt(),
            1 == source.readInt(),
            1 == source.readInt(),
            1 == source.readInt(),
            source.readInt(),
            source.readString(),
            1 == source.readInt(),
            source.readInt(),
            source.readParcelable<LicenseBean>(LicenseBean::class.java.classLoader),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(full_name)
        writeParcelable(owner, 0)
        writeInt((if (isPrivateX) 1 else 0))
        writeString(html_url)
        writeString(description)
        writeInt((if (fork) 1 else 0))
        writeString(url)
        writeString(forks_url)
        writeString(keys_url)
        writeString(collaborators_url)
        writeString(teams_url)
        writeString(hooks_url)
        writeString(issue_events_url)
        writeString(events_url)
        writeString(assignees_url)
        writeString(branches_url)
        writeString(tags_url)
        writeString(blobs_url)
        writeString(git_tags_url)
        writeString(git_refs_url)
        writeString(trees_url)
        writeString(statuses_url)
        writeString(languages_url)
        writeString(stargazers_url)
        writeString(contributors_url)
        writeString(subscribers_url)
        writeString(subscription_url)
        writeString(commits_url)
        writeString(git_commits_url)
        writeString(comments_url)
        writeString(issue_comment_url)
        writeString(contents_url)
        writeString(compare_url)
        writeString(merges_url)
        writeString(archive_url)
        writeString(downloads_url)
        writeString(issues_url)
        writeString(pulls_url)
        writeString(milestones_url)
        writeString(notifications_url)
        writeString(labels_url)
        writeString(releases_url)
        writeString(deployments_url)
        writeString(created_at)
        writeString(updated_at)
        writeString(pushed_at)
        writeString(git_url)
        writeString(ssh_url)
        writeString(clone_url)
        writeString(svn_url)
        writeString(homepage)
        writeInt(size)
        writeInt(stargazers_count)
        writeInt(watchers_count)
        writeString(language)
        writeInt((if (isHas_issues) 1 else 0))
        writeInt((if (isHas_projects) 1 else 0))
        writeInt((if (isHas_downloads) 1 else 0))
        writeInt((if (isHas_wiki) 1 else 0))
        writeInt((if (isHas_pages) 1 else 0))
        writeInt(forks_count)
        writeString(mirror_url)
        writeInt((if (isArchived) 1 else 0))
        writeInt(open_issues_count)
        writeParcelable(license, 0)
        writeInt(forks)
        writeInt(open_issues)
        writeInt(watchers)
        writeString(default_branch)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PublicRepositoriesResponse> = object : Parcelable.Creator<PublicRepositoriesResponse> {
            override fun createFromParcel(source: Parcel): PublicRepositoriesResponse = PublicRepositoriesResponse(source)
            override fun newArray(size: Int): Array<PublicRepositoriesResponse?> = arrayOfNulls(size)
        }
    }
}