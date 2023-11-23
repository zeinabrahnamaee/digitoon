package com.example.divartask.data.remote.params


import com.google.gson.annotations.SerializedName

data class PostsParam(
    @SerializedName("last_post_date")
    val lastPostDate: Int? = null,
    @SerializedName("page")
    val page: Int? = null
)