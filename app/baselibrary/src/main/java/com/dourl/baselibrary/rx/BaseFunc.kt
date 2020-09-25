package com.dourl.baselibrary.rx

import com.dourl.baselibrary.common.BaseResultCode
import com.dourl.baselibrary.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function


/**

@author: douruanliang
@date: 2020/9/25
 通用数据类型转换风格封装
 */
class BaseFunc<T> : Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        if (t.status != BaseResultCode.SUCCESS) {
            return Observable.error(BaseException(t.status, t.message))
        } else {
            return Observable.just(t.data)
        }
    }
}