package com.example.messager

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_message_vertical.view.*

class MessageVerticalAdapter(
    var todos: List<MessageVerticalModel>
) : RecyclerView.Adapter<MessageVerticalAdapter.MessageViewHolder>() {
    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    final val VIEW_TYPE_LOADING: Int = 0
    final val VIEW_TYPE_ITEM: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message_vertical, parent, false)
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (todos !== null) {
            return todos.size
        }
        return 0
    }

    override fun getItemViewType(position: Int): Int {
//        return todos.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM
        return 0;
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.itemView.apply {
            tvName.text = todos[position].name
            tvMessage.text = todos[position].message
            tvTime.text = todos[position].time.toString() + "min"
            tvCount.text = todos[position].count.toString()
            ivAvatar.setImageResource(todos[position].src)


            if (todos[position].isActive) {
                tvTime.setTextColor(ContextCompat.getColor(this.context, R.color.green_line))
            }

            if (todos[position].count === 0) {
                tvCount.visibility = (View.GONE)
            }
        }
    }
}