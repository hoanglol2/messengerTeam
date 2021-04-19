package com.example.messager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.messager.R
import com.example.messager.model.MessageDetailModel
import kotlinx.android.synthetic.main.item_messenger.view.*

class MessageDetailAdapter(
    val todos: List<MessageDetailModel>
) : RecyclerView.Adapter<MessageDetailAdapter.MessengerViewHolder>() {
    inner class MessengerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessengerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_messenger, parent, false)
        return MessengerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: MessengerViewHolder, position: Int) {
        holder.itemView.apply {
            ivMsgAvatar.setImageResource(todos[position].imageFrom)
            tvFromMsg.text = todos[position].messageFrom
            tvLanguage.text = todos[position].language
            tvToMsg.text = todos[position].messageTo
            ivCheck.setImageResource(todos[position].icon)
        }
    }
}