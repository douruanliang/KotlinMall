package com.dourl.baselibrary.injection.module

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
class AppModule ( private val context:BaseApplication){

    @Singleton
    @Provides
    fun providesContext():Context{
        return context
    }
}