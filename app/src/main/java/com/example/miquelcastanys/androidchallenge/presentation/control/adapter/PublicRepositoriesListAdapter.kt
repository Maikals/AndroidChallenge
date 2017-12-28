package com.example.miquelcastanys.androidchallenge.presentation.control.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.miquelcastanys.androidchallenge.R
import com.example.miquelcastanys.androidchallenge.presentation.mainActivity.RepositoryViewHolder
import com.example.miquelcastanys.androidchallenge.presentation.model.PublicRepository


class PublicRepositoriesListAdapter(val repositoriesList: List<PublicRepository>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return RepositoryViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.repository_view_holder, parent, false))
    }

    override fun getItemCount(): Int = repositoriesList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is RepositoryViewHolder) {
            holder.bindView(repositoriesList[position])
        }
    }
}