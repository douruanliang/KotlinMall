package com.dourl.baselibrary.ext

import android.view.View
import com.dourl.baselibrary.data.protocol.BaseResp
import com.dourl.baselibrary.rx.BaseFunBoolean
import com.dourl.baselibrary.rx.BaseFunc
import com.dourl.baselibrary.rx.BaseObserver
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**

@author: douruanliang
@date: 2020/9/25
 */

/**
 * 扩展 Observable 的执行
 */
fun <T> Observable<T>.execute(observer: BaseObserver<T>,
    lifecycleProvider: LifecycleProvider<*>) {
    this.observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribeOn(Schedulers.io())
        .subscribe(observer)

}

/**
 * 简单结果转换 boolean
 */
fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFunBoolean())
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun View.onClick(listener:View.OnClickListener){
    this.setOnClickListener(listener)
}

fun View.onClick(method: ()->Unit){
    this.setOnClickListener{method()}
}
