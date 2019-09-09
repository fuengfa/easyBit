package com.scb.easybit.model

data class UserResponse(
    val firstName: String,
    val lastName: String,
    val password: Any,
    val resourceOwnerId: String,
    val seller: Boolean,
    val userName: Any
)