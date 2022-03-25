package com.example.mytodo1.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.mytodo1.R
import com.example.mytodo1.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : BaseFragment() {
    override fun getLayoutID(): Int {
        return R.layout.fragment_login
    }

    override fun onViewReady(view: View) {
        val webView: WebView = view.findViewById(R.id.webView)
        // Init view
        webView.webViewClient = WebClient()
        val set: WebSettings = webView.settings
        set.javaScriptEnabled = true
        set.builtInZoomControls = true
        webView.loadUrl("https://genk.vn/")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showSnackBar("Login")
        val isNetwork = isNetworkConnected(context)
    }

    class WebClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            url?.let {
                view?.loadUrl(it)
            }
            return true
        }
    }

    companion object {

    }
}


