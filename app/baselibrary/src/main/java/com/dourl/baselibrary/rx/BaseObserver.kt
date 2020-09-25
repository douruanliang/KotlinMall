package com.dourl.baselibrary.rx

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**

@author: douruanliang
@date: 2020/9/25
 */
open class BaseObserver<T> : Observer<T> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable) {
        TODO("Not yet implemented")
    }
}