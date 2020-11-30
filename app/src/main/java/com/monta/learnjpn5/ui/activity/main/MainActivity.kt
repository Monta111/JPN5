package com.monta.learnjpn5.ui.activity.main

import android.os.Bundle
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseActivity
import com.monta.learnjpn5.ui.fragment.home.HomeFragment

class MainActivity : BaseActivity() {

    override val resLayoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null)
            addFragment(HomeFragment(), R.id.fragment_container, false, HomeFragment.TAG)
    }


}