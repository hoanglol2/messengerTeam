package com.example.messager.model

data class MessageVerticalModel(
    val id: Int,
    val src: Int,
    val name: String,
    val message: String,
    val time: Int,
    val count: Int,
    val isActive: Boolean
)