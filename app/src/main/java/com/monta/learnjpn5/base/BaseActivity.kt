package com.monta.learnjpn5.base

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.monta.learnjpn5.MyApplication
import com.monta.learnjpn5.ui.ShareViewModel

abstract class BaseActivity : AppCompatActivity() {

    abstract val resLayoutId: Int

    val viewModel by viewModels<ShareViewModel> { getViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(resLayoutId)
        setupView()
    }

    open fun setupView() {}

    fun addFragment(
        fragment: Fragment,
        containerViewId: Int,
        addToBackStack: Boolean,
        tag: String,
    ) =
        supportFragmentManager.commit {
            add(containerViewId, fragment)
            if (addToBackStack)
                addToBackStack(tag)
        }

    fun replaceFragment(
        fragment: Fragment,
        containerViewId: Int,
        addToBackStack: Boolean,
        tag: String
    ) =
        supportFragmentManager.commit {
            replace(containerViewId, fragment)
            if (addToBackStack)
                addToBackStack(tag)
        }

    fun findFragmentByTag(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    fun getViewModelFactory() = (application as MyApplication).viewModelFactory

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}