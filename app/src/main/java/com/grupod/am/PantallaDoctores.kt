package com.grupod.am

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.grupod.am.PantallaDoctores
import com.grupod.am.Adapter
import com.grupod.am.databinding.ActivityPantallaDoctoresBinding


class PantallaDoctores : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaDoctores
    private val Adapter by lazy{(Adapter)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaDoctoresBinding.inflate(layoutInflater)
        setActionBar(binding, root)
        setRecycleView()
    }
    fun setRecycleView(){
        val mutableList= mutableListOf<String>()
        mutableList.add("Jorge Rene Gutierrez Sandi")
        mutableList.add("Katherine Erika Rodriguez Ortiz")
        mutableList.add("Volkmar Jose Bauer Barragan")
        mutableList.add("Elenea Cristina Cuellar Zumaran")
        Adapter.addPantallaDoctores(mutableList)
        binding.recyclerExample.apply{
            layoutManager =
                LinearLayoutManager (context, LinearLayoutManager.VERTICAL, false)
            adapter = Adapter
        }
    }
}