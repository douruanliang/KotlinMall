package com.dourl.usercenter.data.protocol

/**

@author: douruanliang
@date: 2020/9/25
 */
data class RegisterReq(
    val mobile: String
    , val pwd: String
    , val verifyCode: String
)