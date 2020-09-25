package com.dourl.usercenter.ui.activity

import android.os.Bundle
import com.dourl.baselibrary.ext.onClick
import com.dourl.baselibrary.ui.activity.BaseMvpActivity
import com.dourl.baselibrary.widgets.VerifyButton
import com.dourl.usercenter.R
import com.dourl.usercenter.injection.component.DaggerUserComponent
import com.dourl.usercenter.injection.module.UserModule
import com.dourl.usercenter.presenter.RegisterPresenter
import com.dourl.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class RegisterActivity @Inject constructor() : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterBtn.setOnClickListener {
            mPresenter.register(
                mMobileEt.text.toString(),
                mPwdEt.text.toString(), "123"
            )
        }
        mGetVerifyCodeBtn.setOnVerifyBtnClick(object : VerifyButton.OnVerifyBtnClick{
            override fun onClick() {
                toast("获取验证码") // TODO
            }

        })
        mGetVerifyCodeBtn.onClick {
            mGetVerifyCodeBtn.requestSendVerifyNumber()
        }

    }


    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(activityComponent)
            .userModule(UserModule())
            .build().inject(this)
        mPresenter.mView = this
    }
}