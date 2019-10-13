package com.github.satoshun.example.infinite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.satoshun.example.databinding.InfiniteItemBinding

class InfiniteAdapter(
  private val itemData: List<Data>
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
    val data = itemData[position % itemData.size]
    holder.binding.title.text = data.title
  }
}

data class Data(
  val title: String
)

class InfiniteViewHolder(
  val binding: InfiniteItemBinding
) : RecyclerView.ViewHolder(binding.root)
