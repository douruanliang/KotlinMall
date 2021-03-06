package com.dourl.baselibrary.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.Animatable
import android.view.Gravity
import android.widget.ImageView
import com.dourl.baselibrary.R
import org.jetbrains.anko.find

/**

@author: douruanliang
@date: 2020/9/25
加载对话框
 */
class ProgressLoading private constructor(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    companion object {
        private lateinit var mDialog: ProgressLoading
        private var animDrawable: Animatable? = null
        fun create(context: Context) :ProgressLoading{
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window?.attributes?.gravity = Gravity.CENTER
            val lp = mDialog.window?.attributes
            lp?.dimAmount = 0.2f  //灰暗程度

            mDialog.window?.attributes = lp

            val loadingView = mDialog.find<ImageView>(R.id.iv_loading)
            animDrawable = loadingView.background as Animatable
            return mDialog
        }
    }


    fun showLoading() {
        super.show()
        animDrawable?.start()
    }

    fun hideLoading() {
        super.dismiss()
        animDrawable?.stop()
    }

}