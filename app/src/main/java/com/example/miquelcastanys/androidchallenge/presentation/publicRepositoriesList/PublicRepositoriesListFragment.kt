package com.example.miquelcastanys.androidchallenge.presentation.publicRepositoriesList

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.miquelcastanys.androidchallenge.R
import com.example.miquelcastanys.androidchallenge.presentation.base.BaseFragment
import com.example.miquelcastanys.androidchallenge.presentation.control.adapter.PublicRepositoriesListAdapter
import com.example.miquelcastanys.androidchallenge.presentation.dialogs.UrlDialog
import com.example.miquelcastanys.androidchallenge.presentation.enumerations.EmptyViewModel
import com.example.miquelcastanys.androidchallenge.presentation.interfaces.ActivityFragmentCommunicationInterface
import com.example.miquelcastanys.androidchallenge.presentation.interfaces.OnListItemLongClicked
import com.example.miquelcastanys.androidchallenge.presentation.model.PublicRepository
import kotlinx.android.synthetic.main.fragment_public_repositories_list.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ActivityFragmentCommunicationInterface] interface
 * to handle interaction events.
 */
class PublicRepositoriesListFragment : BaseFragment(), PublicRepositoriesContract.View, OnListItemLongClicked.View {

    private var mListener: ActivityFragmentCommunicationInterface? = null
    private var presenter: PublicRepositoriesContract.Presenter? = null
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    private var visibleItemCount = 0
    private var totalItemCount = 0
    private var pastVisiblesItems = 0
    private var loading: Boolean = false

    companion object {
        val TAG = "PublicReposListFragment"
        private val URL_DIALOG_REQUEST: Int = 99

        fun newInstance(): PublicRepositoriesListFragment = PublicRepositoriesListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_public_repositories_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        presenter?.start()
        scrollRecyclerViewControl()
        setRefreshView()
    }

    private fun scrollRecyclerViewControl() {
        publicRepositoriesRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0) {
                    visibleItemCount = linearLayoutManager.childCount
                    totalItemCount = linearLayoutManager.itemCount
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition()
                    if (!presenter?.isLastPage()!! && !loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = true
                            presenter?.getPublicRepositories()
                        }
                    }
                } else if (linearLayoutManager.findLastVisibleItemPosition() == publicRepositoriesRV.adapter.itemCount - 1
                        && !presenter?.isLastPage()!!) {
                    presenter?.getPublicRepositories()
                    loading = true
                }
            }
        })
    }

    private fun setRefreshView() {
        publicRepositoriesSwipeRefreshLayout.setOnRefreshListener { presenter?.start()
            loading = true
        }
    }

    private fun setRecyclerView() {
        publicRepositoriesRV.layoutManager = linearLayoutManager
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ActivityFragmentCommunicationInterface) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement ActivityFragmentCommunicationInterface")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
        presenter?.detach()
        presenter = null
    }

    override fun setPresenter(presenter: PublicRepositoriesContract.Presenter) {
        this.presenter = presenter
    }

    override fun getPublicRepositoriesOk(publicRepositoryList: List<PublicRepository>) {
        Log.d(TAG, "getPublicRepositoriesOk")
        if (publicRepositoryList.isEmpty()) {
            emptyViewComponent.fillViews(EmptyViewModel.EMPTY)
            showEmptyView()
        } else {
            setAdapter(publicRepositoryList)
            showRecyclerView()
        }
        loading = false

    }

    private fun setAdapter(publicRepositoryList: List<PublicRepository>) {
        if (publicRepositoriesRV.adapter != null) publicRepositoriesRV.adapter.notifyDataSetChanged()
        else publicRepositoriesRV.adapter = PublicRepositoriesListAdapter(publicRepositoryList, this)

    }

    private fun showRecyclerView() {
        emptyViewComponent.visibility = View.GONE
        publicRepositoriesSwipeRefreshLayout.isRefreshing = false
        publicRepositoriesRV.visibility = View.VISIBLE
    }

    override fun getPublicRepositoriesKO() {
        Log.d(TAG, "getPublicRepositoriesKO")
        emptyViewComponent.fillViews(EmptyViewModel.ERROR)
        showEmptyView()
        loading = false
    }

    private fun showEmptyView() {
        publicRepositoriesSwipeRefreshLayout.isRefreshing = false
        emptyViewComponent.visibility = View.VISIBLE
        publicRepositoriesRV.visibility = View.GONE
    }

    override fun showProgressView() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressView() {
        progressBar.visibility = View.GONE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == URL_DIALOG_REQUEST) {
            when (resultCode) {
                UrlDialog.RESULT_OWNER -> {
                    val browserIntent = Intent(Intent.ACTION_VIEW,
                            Uri.parse(getRepository(data?.getIntExtra(UrlDialog.POSITION, 0))?.ownerUrl))
                    activity.startActivity(browserIntent)

                }
                UrlDialog.RESULT_REPOSITORY -> {
                    val browserIntent = Intent(Intent.ACTION_VIEW,
                            Uri.parse(getRepository(data?.getIntExtra(UrlDialog.POSITION, 0))?.repositoryUrl))
                    activity.startActivity(browserIntent)
                }

            }
        }
    }

    private fun getRepository(position: Int?): PublicRepository? =
            if (publicRepositoriesRV.adapter is PublicRepositoriesListAdapter)
                (publicRepositoriesRV.adapter as PublicRepositoriesListAdapter).getItem(position)
            else null

    override fun onItemLongClick(position: Int) {
        Log.d(TAG, "List Item $position clicked")
        val newInstance = UrlDialog.newInstance(position)
        newInstance.setTargetFragment(this, URL_DIALOG_REQUEST)
        newInstance.show(fragmentManager, UrlDialog.TAG)
    }
}
