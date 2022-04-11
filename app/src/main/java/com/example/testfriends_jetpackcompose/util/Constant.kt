package com.example.testfriends_jetpackcompose.util

import android.content.Context
import com.example.testfriends_jetpackcompose.R
import com.example.testfriends_jetpackcompose.data.Question
import java.io.IOException

class Constant {

    companion object {


        val ALREADY_SIGN="address is already in use by another account"


        val questionList =
            listOf(
                Question(0, "qqq", "", 0,"", "", "", "", R.drawable.knowledge,R.drawable.maths,R.drawable.kno,R.drawable.colors,),
                Question(1, "aaa", "", 0,"", "", "", "", R.drawable.knowledge,R.drawable.maths,R.drawable.kno,R.drawable.colors,),
                Question(2, "sss", "", 0,"", "", "", "", R.drawable.knowledge,R.drawable.maths,R.drawable.kno,R.drawable.colors,),
                Question(3, "ddd", "", 0,"", "", "", "", R.drawable.knowledge,R.drawable.maths,R.drawable.kno,R.drawable.colors,),
                Question(4, "dsf", "", 0,"", "", "", "", R.drawable.knowledge,R.drawable.maths,R.drawable.kno,R.drawable.colors,),
                Question(5, "df", "", 0,"", "", "", "", R.drawable.knowledge,R.drawable.maths,R.drawable.kno,R.drawable.colors,),
                Question(6, "df", "", 0,"", "", "", "", R.drawable.knowledge,R.drawable.maths,R.drawable.kno,R.drawable.colors,),
            )

        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}