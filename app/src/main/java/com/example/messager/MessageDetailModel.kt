package com.example.messager

data class MessageDetailModel(
    val id: Int,
    val imageFrom: Int,
    val messageFrom: String,
    val language: String,
    val messageTo: String,
    val icon: Int
)