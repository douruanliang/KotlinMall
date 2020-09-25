package com.dourl.baselibrary.rx

import com.dourl.baselibrary.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**

@author: douruanliang
@date: 2020/9/25
 */
open class BaseObserver<T>(val baseView: BaseView) : Observer<T> {
    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()
    }
}