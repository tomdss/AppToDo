package com.example.mytodo1.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mytodo1.extensions.showSnackBar
import com.example.mytodo1.extensions.showToast

abstract class BaseFragment : Fragment() {

    abstract fun getLayoutID(): Int
    abstract fun onViewReady(view: View)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutID(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewReady(view)
    }

    fun showToast(context: Context, msg: String) {
        (activity as? BaseActivity)?.showToast(context, msg)
    }

    fun showSnackBar( msg: String) {
        (activity as? BaseActivity)?.showSnackBar(msg)
    }

    fun isNetworkConnected(context: Context?): Boolean {
        if(activity is BaseActivity){
            return (activity as? BaseActivity)?.isOnline(context) == true
        }
        return false
    }

}