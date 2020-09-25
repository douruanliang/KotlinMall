package com.dourl.baselibrary.ui.fragment

import android.os.Bundle
import com.dourl.baselibrary.common.BaseApplication
import com.dourl.baselibrary.injection.component.ActivityComponent
import com.dourl.baselibrary.injection.component.DaggerActivityComponent
import com.dourl.baselibrary.injection.module.ActivityModule
import com.dourl.baselibrary.injection.module.LifecycleProviderModule
import com.dourl.baselibrary.presenter.BasePresenter
import com.dourl.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivity()
        injectComponent()
    }

    abstract fun injectComponent()
    private fun initActivity() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((activity as BaseApplication).appComponent)
            .activityModule(ActivityModule(activity!!))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()

    }


    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun onError(text: String) {
        toast(text)
    }
}