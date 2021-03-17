package com.example.ddlite.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.ddlite.R
import com.example.ddlite.utils.DashSharedPref
import kotlinx.android.synthetic.main.fragment_banner.*

class BannerFragment  : Fragment() {

    val TAG : String = BannerFragment::class.simpleName.toString()
    lateinit var rootView :View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_banner, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bannerButton.setOnClickListener {
            DashSharedPref(context).setBannerToShow(false)
            hideBannerFragment(true)
        }
    }

    fun hideBannerFragment(hidden: Boolean) {
        try {
            val trans: FragmentTransaction = requireFragmentManager().beginTransaction()
            if (hidden) {
                trans.hide(this)
            } else {
                trans.show(this)
            }
            trans.commit()
        } catch (e: Exception) {
        }
    }
}