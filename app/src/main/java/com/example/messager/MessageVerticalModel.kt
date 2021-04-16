package com.example.messager

data class MessageVerticalModel(
    val src: Int,
    val name: String,
    val message: String,
    val time: Int,
    val count: Int,
    val isActive: Boolean
)