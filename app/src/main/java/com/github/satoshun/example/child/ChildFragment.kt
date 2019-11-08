package com.github.satoshun.example.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.satoshun.example.databinding.ChildFragBinding

class ChildFragment : Fragment() {
  private lateinit var binding: ChildFragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = ChildFragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.viewPager.isUserInputEnabled = false
    val adapter = ChildAdapter(this)
    binding.viewPager.adapter = adapter

    val childView = binding.viewPager[0] as RecyclerView
    childView.setItemViewCacheSize(5)

    binding.bottom.setOnClickListener {
      binding.viewPager.setCurrentItem((binding.viewPager.currentItem + 1) % 5, false)
    }
  }
}

class ChildAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
  override fun getItemCount(): Int = 5

  override fun createFragment(position: Int): Fragment {
    return when (position % 5) {
      0 -> Child1Fragment()
      1 -> Child2Fragment()
      2 -> Child3Fragment()
      3 -> Child4Fragment()
      else -> Child5Fragment()
    }
  }
}

class Child1Fragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return TextView(requireContext()).apply { text = "Child1Fragment" }
  }
}

class Child2Fragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return TextView(requireContext()).apply { text = "Child2Fragment" }
  }
}

class Child3Fragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return TextView(requireContext()).apply { text = "Child3Fragment" }
  }
}

class Child4Fragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return TextView(requireContext()).apply { text = "Child4Fragment" }
  }
}

class Child5Fragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return TextView(requireContext()).apply { text = "Child5Fragment" }
  }
}
