package com.example.testfriends_jetpackcompose.util

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import com.example.testfriends_jetpackcompose.data.User
import com.google.gson.Gson


class Utils {

    companion object {
        fun isEmailValid(target: CharSequence?): Boolean {
            return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }

        fun convertToUser(userString: String): User {
            //val json = """{"id": "0", "token": "123445556", "username" : "abdellah","img" : "000" }"""
            val gson = Gson()
            return gson.fromJson(userString, User::class.java)
        }

        fun compareResults(sender: String, myAnswers: String): Int {
            var res = 0
            val list1 = sender.split(",").toTypedArray()
            val list2 = myAnswers.split(",").toTypedArray()
            var i = 0
            for (item in list1) {
                if (item == list2[i])
                    res++
                i++
            }
            Log.d("question sender", sender)
            Log.d("question q", myAnswers)
            res = (res * 100) / list1.size
            return res
        }

    }

}