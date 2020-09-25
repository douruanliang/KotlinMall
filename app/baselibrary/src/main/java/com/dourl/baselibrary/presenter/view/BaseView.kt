package com.dourl.baselibrary.presenter.view

/**

@author: douruanliang
@date: 2020/9/25
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError (msg:String)
}