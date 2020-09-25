package com.dourl.usercenter.service

import io.reactivex.Observable


/**

@author: douruanliang
@date: 2020/9/25
 */
interface UserService {
    fun register(mobile: String, pwd: String,verifyCode: String): Observable<Boolean>;
}