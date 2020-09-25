package com.dourl.baselibrary.presenter

import com.dourl.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle2.LifecycleProvider
import javax.inject.Inject

/**

@author: douruanliang
@date: 2020/9/25
 */
open class BasePresenter<T:BaseView> {
    lateinit var mView :T
    @Inject
    lateinit var mLifecycleProvider: LifecycleProvider<*>
}