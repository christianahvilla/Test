package com.werden.test.api

import android.util.Log
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonArrayRequest
import org.json.JSONArray

class ServiceVolley : ServiceInterface {
    val TAG: String = ServiceVolley::class.java.simpleName

    override fun get(path: String, completionHandler: (response: JSONArray?) -> Unit) {
        val jsonObjReq = object : JsonArrayRequest(
            Method.GET, path, null,
            Response.Listener<JSONArray> { response ->
                Log.d(TAG, "/get request OK! Response: $response")
                completionHandler(response)
            },
            Response.ErrorListener { error ->
                VolleyLog.e(TAG, "/get request fail! Error: ${error.message}")
                completionHandler(null)
            }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json")
                headers.put("Accept", "application/json")
                return headers
            }
        }

        BackendVolley.instance?.addToRequestQueue(jsonObjReq, TAG)
    }
}