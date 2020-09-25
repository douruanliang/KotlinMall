package com.dourl.baselibrary.injection.module

import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Module
import dagger.Provides

/**

@author: douruanliang
@date: 2020/9/25
Rx 生命周期管理用户的module
 */
@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {
    @Provides
    fun providesLifecycle(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}