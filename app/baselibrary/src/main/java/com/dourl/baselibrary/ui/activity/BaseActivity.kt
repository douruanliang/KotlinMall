package com.dourl.baselibrary.ui.activity

import android.os.Bundle
import com.dourl.baselibrary.common.AppManager
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**

@author: douruanliang
@date: 2020/9/25
 */
open class BaseActivity : RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}