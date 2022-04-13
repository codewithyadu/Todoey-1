package com.example.todoey.model.repository

import com.example.todoey.MyApplication
import com.example.todoey.model.data.fact.FactApi
import com.example.todoey.model.network.Internet
import com.example.todoey.model.network.RetrofitHelper

class FactRepository {

    suspend fun getFact(): String? {
        if (Internet.hasInternetAccess()) {
            val factApi = RetrofitHelper.getInstance().create(FactApi::class.java)
            // for string values, either use string resource or create constants
            val res = factApi.getFact("en")
            with(MyApplication.getSharedPrefs().edit()) {
                // for string values, either use string resource or create constants
                putString("fact", res.body()?.text)
                apply()
            }
            return res.body()?.text
        } else {
            // for string values, either use string resource or create constants
            if (!MyApplication.getSharedPrefs().getString("fact", "").isNullOrEmpty()) {
                // for string values, either use string resource or create constants
                return MyApplication.getSharedPrefs().getString("fact", "")
            }
             // for string values, either use string resource or create constants
            return ""
        }
    }

}
