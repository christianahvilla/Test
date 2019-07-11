package com.werden.test.api

import org.json.JSONArray

class Controller constructor(serviceInjection: ServiceInterface): ServiceInterface {
    private val service: ServiceInterface = serviceInjection

    override fun get(path: String, completionHandler: (response: JSONArray?) -> Unit) {
        service.get(path, completionHandler)
    }
}