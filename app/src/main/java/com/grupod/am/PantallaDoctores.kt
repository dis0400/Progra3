package com.grupod.am

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.grupod.am.databinding.ActivityPantallaDoctoresBinding


class PantallaDoctores : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaDoctoresBinding

    private val DoctoresAdapter by lazy{DoctoresAdapter()}
    private val DoctoresAdapter2 by lazy { DoctoresAdapter() }
    private val DoctoresAdapter3 by lazy { DoctoresAdapter ()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaDoctoresBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycleView()
    }
    fun setRecycleView(){

        val mutableList= mutableListOf<String>()
        mutableList.add("Jorge Rene Gutierrez Sandi")
        mutableList.add("Katherine Erika Rodriguez Ortiz")
        mutableList.add("Volkmar Jose Bauer Barragan")
        mutableList.add("Elenea Cristina Cuellar Zumaran")
        DoctoresAdapter.addPantallaDoctores(mutableList)

         val mutableList2= mutableListOf<String>()
        mutableList2.add("Medicina General")
        mutableList2.add("Pediatría")
        mutableList2.add("Odontología")
        mutableList2.add("Traumatología")
        DoctoresAdapter2.addPantallaDoctores(mutableList2)

        val mutableList3 = mutableListOf<String>()
        mutableList3.add("Hospital de la Mujer")
        mutableList3.add("Hospital Arco Iris")
        mutableList3.add("Hospital de Clinicas")
        mutableList3.add("Hospital Materno Infantil")
        DoctoresAdapter3.addPantallaDoctores(mutableList3)

        binding.recycleExample.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ItemDoctores
        }
        binding.recycleExample2.apply {
            layoutManager =

        }


    }
}