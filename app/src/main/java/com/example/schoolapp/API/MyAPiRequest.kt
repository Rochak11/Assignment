package com.API

import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException

abstract class MyAPiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            Log.e("MyAPiRequest", "success: " + response.body().toString())
            return response.body()!!
        } else {
            //   val error: String = response.errorBody().toString()
            val error = response.errorBody()?.string()
            Log.e("MyAPiRequest", "apiRequest: " + error)
            val message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("success"))
                } catch (e: JSONException) {
                }
                message.append("\n")
            }
            message.append("Error code : ${response.code()}")
            throw IOException(message.toString())
        }
    }
}