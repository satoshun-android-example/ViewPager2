package com.github.satoshun.example.common

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : AppCompatActivity(), CoroutineScope {
  private val job = Job()
  final override val coroutineContext: CoroutineContext
    get() = Dispatchers.Main + job

  override fun onDestroy() {
    job.cancel()
    super.onDestroy()
  }
}
