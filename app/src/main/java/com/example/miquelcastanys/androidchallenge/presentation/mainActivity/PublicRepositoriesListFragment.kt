package com.example.miquelcastanys.androidchallenge.presentation.mainActivity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.miquelcastanys.androidchallenge.R
import com.example.miquelcastanys.androidchallenge.presentation.interfaces.ActivityFragmentCommunicationInterface
import com.example.miquelcastanys.androidchallenge.presentation.model.PublicRepository
import kotlinx.android.synthetic.main.fragment_public_repositories_list.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ActivityFragmentCommunicationInterface] interface
 * to handle interaction events.
 */
class PublicRepositoriesListFragment : Fragment(), PublicRepositoriesContract.View {

    private var mListener: ActivityFragmentCommunicationInterface? = null
    private lateinit var presenter: PublicRepositoriesContract.Presenter

    companion object {
        val TAG = "PublicReposListFragment"
        fun newInstance() : PublicRepositoriesListFragment = PublicRepositoriesListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_public_repositories_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        publicRepositoriesRV.layoutManager = LinearLayoutManager(context)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ActivityFragmentCommunicationInterface) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun setPresenter(presenter: PublicRepositoriesContract.Presenter) {
        this.presenter = presenter
    }

    override fun getPublicRepositoriesOk(publicRepositoryList: List<PublicRepository>) {
        Log.d(TAG, publicRepositoryList.toString())
    }

    override fun getPublicRepositoriesKO() {
    }
}
