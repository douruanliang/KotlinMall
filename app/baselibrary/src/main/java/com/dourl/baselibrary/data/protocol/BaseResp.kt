package com.dourl.baselibrary.data.protocol

/**

@author: douruanliang
@date: 2020/9/25
 */
open class BaseResp<out T> (val status:Int,val message:String,val data:T)