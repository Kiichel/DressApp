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

class MessagesRecyclerViewAdapter(_messages: List<Message>) :
    RecyclerView.Adapter<MessagesRecyclerViewAdapter.MessagesHolder>() {
    private val messages = _messages

    class MessagesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userImgId: ImageView? = null
        var usernameId: TextView? = null
        var messageTextId: TextView? = null


        init {
            userImgId = itemView.findViewById(R.id.userImgId)
            usernameId = itemView.findViewById(R.id.usernameId)
            messageTextId = itemView.findViewById(R.id.messageTextId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return MessagesHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessagesHolder, position: Int) {
        holder.userImgId?.let {
            Glide
                .with(it.context)
                .load(messages[position].getImageUrl())
                .into(it)
        }
        holder.usernameId?.text = messages[position].getUsername()
        holder.messageTextId?.text = messages[position].getTextMessage()
    }

    override fun getItemCount() = messages.size

}