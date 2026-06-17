package com.v2ray.ang.plugin

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.v2ray.ang.AngApplication

fun AngApplication.getPackageInfo(packageName: String): PackageInfo =
    packageManager.getPackageInfo(packageName, PackageManager.GET_META_DATA)
