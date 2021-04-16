package com.example.messager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_message_horizontal.view.*

class MessageHorizontalAdapter(
    var todos: List<MessageHorizontalModel>
) : RecyclerView.Adapter<MessageHorizontalAdapter.MessageViewHolder>() {
    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message_horizontal, parent, false)
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.itemView.apply {
            tvName.text = todos[position].name
            ivImage.setImageResource(todos[position].src)
        }
    }


}