package com.werden.test.api

import org.json.JSONArray

interface ServiceInterface {
    fun get(path: String, completionHandler: (response: JSONArray?) -> Unit)
}