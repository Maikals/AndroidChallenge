package com.example.miquelcastanys.androidchallenge.presentation.mainActivity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.miquelcastanys.androidchallenge.R
import com.example.miquelcastanys.androidchallenge.domain.data.source.AndroidChallengeSourceImpl
import com.example.miquelcastanys.androidchallenge.presentation.base.BaseActivity
import com.example.miquelcastanys.androidchallenge.presentation.interfaces.ActivityFragmentCommunicationInterface
import com.example.miquelcastanys.androidchallenge.presentation.publicRepositoriesList.PublicRepositoriesListFragment
import com.example.miquelcastanys.androidchallenge.presentation.publicRepositoriesList.PublicRepositoriesPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), ActivityFragmentCommunicationInterface {

    private var currentFragment: Fragment? = null
    private var currentTag: String? = null

    companion object {
        const val TAG: String = "MainActivity"
        private const val CURRENT_FRAGMENT_TAG: String = "currentTag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        if (savedInstanceState == null || !savedInstanceState.containsKey(currentTag)) {
            createFragment()
        } else {
            currentTag = savedInstanceState.getString(CURRENT_FRAGMENT_TAG)
            currentFragment = supportFragmentManager.getFragment(savedInstanceState, currentTag)
        }
        setFragment()
    }

    private fun setFragment() =
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, currentFragment, currentTag).commit()

    override fun onSaveInstanceState(outState: Bundle?) {
        supportFragmentManager.putFragment(outState, currentTag, currentFragment)
        outState?.putString(CURRENT_FRAGMENT_TAG, currentTag)
        super.onSaveInstanceState(outState)
    }

    private fun createFragment() {
        val publicRepositoriesListFragment = PublicRepositoriesListFragment.newInstance()
        val presenter = PublicRepositoriesPresenter()
        presenter.attach(this, publicRepositoriesListFragment, AndroidChallengeSourceImpl())
        publicRepositoriesListFragment.setPresenter(presenter)
        currentFragment = publicRepositoriesListFragment
        currentTag = PublicRepositoriesListFragment.TAG
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }
}
