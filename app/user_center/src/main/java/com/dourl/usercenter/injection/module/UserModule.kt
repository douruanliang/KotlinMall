package com.dourl.usercenter.injection.module

import com.dourl.usercenter.service.UserService
import com.dourl.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**

@author: douruanliang
@date: 2020/9/25
 */
@Module
class UserModule {

    @Provides
    fun providerUserService(userService:UserServiceImpl):UserService{
      return userService
    }
}