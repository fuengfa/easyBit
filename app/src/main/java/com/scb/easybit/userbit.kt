package com.scb.easybit

data class Userbid(
    val data: List<Data>,
    val status: Status
)

data class Status(
    val code: Int,
    val description: String
)

data class Data(
    val bidUser: String,
    val detail: String,
    val endTime: String,
    val id: Int,
    val pictures: List<Picture>,
    val price: Int,
    val priceGrape: Int,
    val seller: String,
    val startTime: String,
    val tags: List<Tag>,
    val topic: String
)

data class Picture(
    val image: String
)

data class Tag(
    val tagName: String
)