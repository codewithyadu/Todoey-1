package com.example.todoey.model.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.todoey.MyApplication


object Internet {
    fun hasInternetAccess(): Boolean {
        // cm ? -> use proper naming conventions 
        val cm = MyApplication.getContext()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // cap ? -> use proper naming conventions 
            val cap = cm.getNetworkCapabilities(cm.activeNetwork) ?: return false
            return cap.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else
            for (n in cm.allNetworks) {
                 // nInfo ? -> use proper naming conventions 
                val nInfo = cm.getNetworkInfo(n)
                if (nInfo != null && nInfo.isConnected) return true
            }

        return false
    }
}
