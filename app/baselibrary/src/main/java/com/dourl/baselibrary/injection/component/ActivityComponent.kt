package com.dourl.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.dourl.baselibrary.injection.ActivityScope
import com.dourl.baselibrary.injection.module.ActivityModule
import com.dourl.baselibrary.injection.module.AppModule
import com.dourl.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Component
import javax.inject.Singleton

/**

@author: douruanliang
@date: 2020/9/25

 activity 级别的 scope
 */
@ActivityScope
@Component(dependencies = [(AppComponent::class)],
    modules = [(ActivityModule::class),(LifecycleProviderModule::class)])
interface ActivityComponent {
    fun activity():Activity
    fun context():Context
    fun lifecycleProvider():LifecycleProvider<*>
}