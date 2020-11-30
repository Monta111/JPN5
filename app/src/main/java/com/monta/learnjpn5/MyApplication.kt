package com.monta.learnjpn5

import android.app.Application
import com.monta.learnjpn5.di.component.DaggerApplicationComponent
import javax.inject.Inject

class MyApplication : Application() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent.builder()
            .context(this)
            .build()
            .inject(this)
    }

}