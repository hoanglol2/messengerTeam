package com.example.messager.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.messager.R
import com.example.messager.model.MessageVerticalModel
import com.example.messager.ui.DetailMessageFragment
import com.example.messager.ui.LogInFragment
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

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.itemView.apply {
            tvName.text = todos[position].name
            tvMessage.text = todos[position].message
            tvTime.text = todos[position].time.toString() + "min"
            tvCount.text = todos[position].count.toString()
            ivAvatar.setImageResource(todos[position].src)


            if (todos[position].isActive) {
                tvTime.setTextColor(
                    ContextCompat.getColor(
                        this.context,
                        R.color.green_line
                    )
                )
            }

            if (todos[position].count === 0) {
                tvCount.visibility = (View.GONE)
            }

            setOnClickListener {
                val packages = bundleOf(keyPackage to todos[position].id)
                (this.context as? AppCompatActivity)?.supportFragmentManager?.beginTransaction()
                    ?.add(android.R.id.content, DetailMessageFragment.newInstance(packages), "LogInFragment")?.addToBackStack("")?.commit()

            }
        }
    }

    companion object {
        const val keyPackage = "myNavigation"
    }

}