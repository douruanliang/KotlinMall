package com.dourl.baselibrary.presenter

import android.content.Context
import com.dourl.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle2.LifecycleProvider
import com.wuc.kotlin.base.utils.NetWorkUtils
import javax.inject.Inject

/**

@author: douruanliang
@date: 2020/9/25
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var mLifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context
    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context))
            return true
        mView.onError("网络不可用")
        return false
    }
}