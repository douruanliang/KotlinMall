package com.dourl.usercenter.service.impl

import com.dourl.baselibrary.ext.convertBoolean
import com.dourl.usercenter.data.repository.UserRepository
import com.dourl.usercenter.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

/**

@author: douruanliang
@date: 2020/9/25
 */
class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var repository: UserRepository
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verifyCode).convertBoolean()
    }


}