package com.dourl.usercenter.injection.component

import com.dourl.baselibrary.injection.PerComponentScope
import com.dourl.baselibrary.injection.component.ActivityComponent
import com.dourl.usercenter.injection.module.UserModule
import com.dourl.usercenter.ui.activity.RegisterActivity
import dagger.Component

/**

@author: douruanliang
@date: 2020/9/25
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],
    modules = [(UserModule::class)])
interface UserComponent {
    fun inject(activity: RegisterActivity)
}