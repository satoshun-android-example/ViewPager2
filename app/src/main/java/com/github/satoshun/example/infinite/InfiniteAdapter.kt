package com.github.satoshun.example.infinite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.satoshun.example.databinding.InfiniteItemBinding

class InfiniteAdapter(
  private val data: List<InfiniteData>
) : RecyclerView.Adapter<InfiniteViewHolder>() {

  override fun getItemCount(): Int = Int.MAX_VALUE

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfiniteViewHolder =
    InfiniteViewHolder(
      InfiniteItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      )
    )

  override fun onBindViewHolder(holder: InfiniteViewHolder, position: Int) {
    val data = data[position % data.size]
    holder.binding.title.text = data.title
  }
}

data class InfiniteData(
  val title: String
)

class InfiniteViewHolder(
  val binding: InfiniteItemBinding
) : RecyclerView.ViewHolder(binding.root)
