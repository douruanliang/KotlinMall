package com.dourl.usercenter.data.repository

import com.dourl.baselibrary.data.net.RetrofitFactory
import com.dourl.baselibrary.data.protocol.BaseResp
import com.dourl.usercenter.data.api.UserApi
import com.dourl.usercenter.data.protocol.RegisterReq
import io.reactivex.Observable
import javax.inject.Inject

/**

@author: douruanliang
@date: 2020/9/25
 */
class UserRepository @Inject constructor() {
    fun register(
        mobile: String, pwd: String, verifyCode: String
    ): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
            .register(RegisterReq(mobile, pwd, verifyCode))
    }
}