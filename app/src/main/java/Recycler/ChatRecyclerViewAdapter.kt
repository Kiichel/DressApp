package Recycler

import Model.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dressapp.R

class ChatRecyclerViewAdapter(_messages: List<Message>) :
    RecyclerView.Adapter<ChatRecyclerViewAdapter.MessagesHolder>() {
    private var messages = _messages

    class MessagesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chatMessageTextId: TextView? = null

        init {
            chatMessageTextId = itemView.findViewById(R.id.chatText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        return MessagesHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessagesHolder, position: Int) {
        holder.chatMessageTextId?.text = messages[position].textMessage
    }

    override fun getItemCount() = messages.size
}
