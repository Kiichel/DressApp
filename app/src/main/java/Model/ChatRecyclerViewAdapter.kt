package Model

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dressapp.R

class ChatRecyclerViewAdapter(_messages: List<Message>) :
    RecyclerView.Adapter<ChatRecyclerViewAdapter.MessagesHolder>() {
    private val messages = _messages

    class MessagesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chatMessageTextId: TextView? = null


        init {
            chatMessageTextId = itemView.findViewById(R.id.chatText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_cardview, parent, false)
        return MessagesHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessagesHolder, position: Int) {
        holder.chatMessageTextId?.text = messages[position].getTextMessage()
    }

    override fun getItemCount() = messages.size

}
