package com.dourl.baselibrary.injection.component

import android.content.Context
import com.dourl.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**

@author: douruanliang
@date: 2020/9/25
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun context():Context
}