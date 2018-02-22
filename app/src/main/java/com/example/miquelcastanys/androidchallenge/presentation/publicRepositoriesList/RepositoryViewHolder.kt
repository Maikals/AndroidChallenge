package com.example.miquelcastanys.androidchallenge.presentation.publicRepositoriesList

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.miquelcastanys.androidchallenge.presentation.interfaces.OnListItemLongClicked
import com.example.miquelcastanys.androidchallenge.presentation.model.presentation.PublicRepository
import kotlinx.android.synthetic.main.repository_view_holder.view.*


class RepositoryViewHolder(val view: View, val listener: OnListItemLongClicked.Adapter) : RecyclerView.ViewHolder(view) {

    fun bindView(repository: PublicRepository) {
        view.name.text = repository.name
        view.description.text = repository.description
        view.loginOwner.text = repository.login
        view.cardView.setCardBackgroundColor(
                if (repository.forkFlag != null && repository.forkFlag)
                    ContextCompat.getColor(view.context, android.R.color.white)
                else
                    ContextCompat.getColor(view.context, android.R.color.holo_green_light))
        view.cardView.setOnLongClickListener { listener.onItemLongClick(adapterPosition)
            true
        }
    }
}