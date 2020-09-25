package com.dourl.baselibrary.injection.module

import android.app.Activity
import android.content.Context
import com.dourl.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**

@author: douruanliang
@date: 2020/9/25
 */
@Module
class ActivityModule (private val activity:Activity){
    @Provides
    fun providesContext():Activity{
        return activity
    }
}