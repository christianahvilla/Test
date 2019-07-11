package com.werden.test.models

import com.google.gson.annotations.SerializedName

data class JsonModel (
    @SerializedName("userId") var userId: Int,
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("completed") var completed: Boolean
)
