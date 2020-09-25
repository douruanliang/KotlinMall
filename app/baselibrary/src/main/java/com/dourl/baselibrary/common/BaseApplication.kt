package com.dourl.baselibrary.common

import android.app.Application
import com.dourl.baselibrary.injection.component.AppComponent
import com.dourl.baselibrary.injection.component.DaggerAppComponent
import com.dourl.baselibrary.injection.module.AppModule

/**

@author: douruanliang
@date: 2020/9/25
 */
class BaseApplication : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initInjection()
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}