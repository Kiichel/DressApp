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

class DressRecyclerViewAdapter(_dress: List<Dress>) :
    RecyclerView.Adapter<DressRecyclerViewAdapter.DressHolder>() {
    private var dress = _dress

    class DressHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dressImageId: ImageView? = null
        var dressPriseId: TextView? = null
        var dressNameId: TextView? = null

        init {
            dressImageId = itemView.findViewById(R.id.dressImageId)
            dressPriseId = itemView.findViewById(R.id.dressPriseId)
            dressNameId = itemView.findViewById(R.id.dressNameId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DressHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.dress_cardview, parent, false)
        return DressHolder(itemView)
    }

    override fun onBindViewHolder(holder: DressHolder, position: Int) {
        holder.dressImageId?.let {
            Glide
                .with(it.context)
                .load(dress[position].dressImage)
                .into(it)
        }
        holder.dressNameId?.text = dress[position].dressName
        holder.dressPriseId?.text = dress[position].dressPrice
    }


    override fun getItemCount() = dress.size
}
