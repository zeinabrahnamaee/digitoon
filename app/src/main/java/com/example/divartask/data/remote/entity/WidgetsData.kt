package com.example.divartask.data.remote.entity


import com.google.gson.annotations.SerializedName

data class Widgets(
    @SerializedName("widget_list")
    val widgetList: List<Widget>? = null
) {
    data class Widget(
        @SerializedName("data")
        val data: DataModel? = null,
        @SerializedName("widget_type")
        val widgetType: String? = null
    )
}

data class DataModel(
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("district")
    val district: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("token")
    val token: String? = null
)