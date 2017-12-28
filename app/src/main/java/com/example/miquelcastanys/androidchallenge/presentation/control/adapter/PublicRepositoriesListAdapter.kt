package com.example.miquelcastanys.androidchallenge.presentation.control.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.miquelcastanys.androidchallenge.R
import com.example.miquelcastanys.androidchallenge.presentation.mainActivity.FooterViewHolder
import com.example.miquelcastanys.androidchallenge.presentation.mainActivity.RepositoryViewHolder
import com.example.miquelcastanys.androidchallenge.presentation.model.PublicRepository
import com.example.miquelcastanys.androidchallenge.presentation.utils.Constants


class PublicRepositoriesListAdapter(val repositoriesList: List<PublicRepository>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Constants.PUBLIC_REPOSITORY_TYPE -> RepositoryViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.repository_view_holder, parent, false))
            else -> FooterViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.footer_view_holder, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int = repositoriesList[position].type



    override fun getItemCount(): Int = repositoriesList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is RepositoryViewHolder) {
            holder.bindView(repositoriesList[position])
        }
    }
}