package com.example.mytodo1.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.mytodo1.R
import com.example.mytodo1.base.BaseActivity
import com.example.mytodo1.service.FService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MainActivity : BaseActivity() {

    private val TAG = "MainActivity"

    override fun getLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        // init View
        // Check Internet
//        isOnline(baseContext)
//        val myString = "Hello Everyone"
//        val result = myString.removeFirstLastChar()
//        Log.i("MainActivity", result)
//        loadFragment(R.id.flLayout, LoginFragment())
        btnRx.setOnClickListener {
            Timber.d("startRXStream")
            Log.d(TAG, "startRXStream")
//            startRXStream()
            startRXStreamRxKotlin()
        }
    }

    private fun startRXStreamRxKotlin() {
        val fsv = FService()
        val intent = Intent()
        fsv.startService(intent)
        val list = arrayListOf<String>("1", "2", "3", "4", "5", "6")
        list.toObservable().subscribeBy(
            onNext = { Log.d(TAG, "onNext rxKotlin = $it") },
            onError = { Log.d(TAG, "onError rxKotlin " + it.printStackTrace()) },
            onComplete = { Log.d(TAG, "onComplete rxKotlin") }
        )
    }

    private fun startRXStream() {
        val myObservable: Observable<String> = getObservable()
        val myObserver: Observer<String> = getObserver()
        // Subscribe myObserver to Observable
        myObservable.subscribe(myObserver)
    }

    private fun getObserver(): Observer<String> {

        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Timber.d("onSubscribe")
                Log.d(TAG, "onSubscribe")
            }

            override fun onNext(t: String) {
                Timber.d("onNext")
                Log.d(TAG, "onNext")
            }

            override fun onError(e: Throwable) {
                Timber.d("onError")
                Log.d(TAG, "onError")
            }

            override fun onComplete() {
                Timber.d("onComplete")
                Log.d(TAG, "onComplete")
            }

        }
    }

    private fun getObservable(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
    }

}