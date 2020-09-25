package com.dourl.usercenter.data.api

import com.dourl.baselibrary.data.protocol.BaseResp
import com.dourl.usercenter.data.protocol.RegisterReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**

@author: douruanliang
@date: 2020/9/25
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
}