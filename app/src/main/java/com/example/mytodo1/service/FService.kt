package com.example.mytodo1.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class FService : Service(){

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        Log.d("FService","onStartCommand")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("FService","onCreate")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
        Log.d("FService","onUnbind")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FService","onDestroy")
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.d("FService","onBind")
        TODO("Not yet implemented")
    }

}