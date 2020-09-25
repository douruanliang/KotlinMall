package com.dourl.usercenter.presenter

import com.dourl.baselibrary.ext.execute
import com.dourl.baselibrary.presenter.BasePresenter
import com.dourl.baselibrary.rx.BaseObserver
import com.dourl.usercenter.presenter.view.RegisterView
import com.dourl.usercenter.service.impl.UserServiceImpl
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**

@author: douruanliang
@date: 2020/9/25
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserServiceImpl
    fun register(mobile: String, pwd: String, verifyCode: String) {

        userService.register(mobile, pwd, verifyCode)
            .execute(object :BaseObserver<Boolean>(){
                override fun onNext(t: Boolean) {
                    super.onNext(t)
                    if (t)
                        mView.onRegisterResult("注册成功")
                }
            },mLifecycleProvider)
    }
}