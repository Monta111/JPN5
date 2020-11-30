package com.monta.learnjpn5.di.component

import android.content.Context
import com.monta.learnjpn5.MyApplication
import com.monta.learnjpn5.di.module.ApplicationModule
import com.monta.learnjpn5.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): ApplicationComponent
    }
}