package com.dourl.baselibrary.ui.activity

import android.os.Bundle
import com.dourl.baselibrary.common.BaseApplication
import com.dourl.baselibrary.injection.component.ActivityComponent
import com.dourl.baselibrary.injection.component.DaggerActivityComponent
import com.dourl.baselibrary.injection.module.ActivityModule
import com.dourl.baselibrary.injection.module.LifecycleProviderModule
import com.dourl.baselibrary.presenter.BasePresenter
import com.dourl.baselibrary.presenter.view.BaseView
import com.dourl.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T
    lateinit var activityComponent: ActivityComponent

    private lateinit var mLoading: ProgressLoading
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivity()
        injectComponent()
        mLoading = ProgressLoading.create(this)
    }

    abstract fun injectComponent()
    private fun initActivity() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()

    }



    override fun showLoading() {
        mLoading.showLoading()
    }

    override fun hideLoading() {
        mLoading.hideLoading()
    }

    override fun onError(text:String) {
        toast(text)
    }
}