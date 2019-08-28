package com.github.satoshun.example

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.satoshun.example.databinding.Viewpager2FragBinding

private val colors = intArrayOf(
  Color.BLACK,
  Color.BLUE,
  Color.CYAN,
  Color.GREEN
)

internal class FragmentExample : Fragment() {
  companion object {
    operator fun invoke(count: Int): Fragment {
      return FragmentExample().apply {
        arguments = bundleOf("count" to count)
      }
    }
  }

  private lateinit var binding: Viewpager2FragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = Viewpager2FragBinding.inflate(
      inflater,
      container,
      false
    )
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val count = requireArguments().getInt("count", 0)
    binding.title.text = count.toString()
    binding.root.setBackgroundColor(colors[count % colors.size])
  }
}

internal class FragmentStateAdapterExample(
  activity: FragmentActivity
) : FragmentStateAdapter(activity) {
  override fun createFragment(position: Int) = FragmentExample(position)

  override fun getItemCount() = 100
}
