package com.grupod.am

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.grupod.am.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var searchResultActivity: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.messageMain.setOnClickListener {
            goToSearch()
        }

        onSearchActivityResult()
    }

    private fun goToSearch() {
        searchResultActivity?.launch(Intent(this, Login::class.java))
    }

    private fun onSearchActivityResult() {
        searchResultActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data?.getStringExtra(Constat.ETER)
                binding.messageMain.text = data
            }
        }
    }
}