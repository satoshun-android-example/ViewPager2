package com.github.satoshun.example.limit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.LimitActBinding

class LimitActivity : AppCompatActivity() {
  private lateinit var binding: LimitActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.limit_act)
    setSupportActionBar(binding.toolbar)

    supportFragmentManager.commit {
      replace(R.id.container, LimitFragment())
    }
  }
}