package com.github.satoshun.example.child

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.ChildActBinding

class ChildActivity : AppCompatActivity() {
  private lateinit var binding: ChildActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.child_act)

    if (savedInstanceState == null) {
      supportFragmentManager.commit(allowStateLoss = true) {
        replace(R.id.main_frame, ChildFragment())
      }
    }
  }
}
