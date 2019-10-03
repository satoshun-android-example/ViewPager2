package com.github.satoshun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.satoshun.example.databinding.Main2FragBinding

class MainFragment2 : Fragment() {
  private lateinit var binding: Main2FragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = Main2FragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val adapter = ViewPagerAdapter()
    binding.recycler.adapter = adapter
//    binding.recycler.layoutManager = LinearLayoutManager(context)
    binding.recycler.layoutManager = GridLayoutManager(context, 1)
  }
}
