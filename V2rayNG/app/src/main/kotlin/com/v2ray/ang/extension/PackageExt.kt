package com.v2ray.ang.extension

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.v2ray.ang.AngApplication

fun AngApplication.listenForPackageChanges(action: () -> Unit): BroadcastReceiver {
    val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            action()
        }
    }
    val filter = IntentFilter().apply {
        addAction(Intent.ACTION_PACKAGE_ADDED)
        addAction(Intent.ACTION_PACKAGE_REMOVED)
        addAction(Intent.ACTION_PACKAGE_CHANGED)
        addDataScheme("package")
    }
    registerReceiver(receiver, filter)
    return receiver
}
