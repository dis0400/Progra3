package com.grupod.am

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.grupod.am.databinding.ActivityPantallaDoctoresBinding


class PantallaDoctores : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaDoctoresBinding
    val pantallaDoctores = mutableListOf<String>()

    private var DoctoresAdapter by lazy { DoctoresAdapter }
    private val DoctoresAdapter2 by lazy { DoctoresAdapter }
    private val DoctoresAdapter3 by lazy { DoctoresAdapter }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaDoctoresBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycleView()
    }

    fun setRecycleView() {

        val mutableList = mutableListOf<String>()
        mutableList.add("Jorge Rene Gutierrez Sandi")
        mutableList.add("Katherine Erika Rodriguez Ortiz")
        mutableList.add("Volkmar Jose Bauer Barragan")
        mutableList.add("Elenea Cristina Cuellar Zumaran")

        DoctoresAdapter.addpantallaDoctores(mutableList)

        val mutableList2 = mutableListOf<String>()
        mutableList2.add("Medicina General")
        mutableList2.add("Pediatría")
        mutableList2.add("Odontología")
        mutableList2.add("Traumatología")
        DoctoresAdapter2.addpantallaDoctores(mutableList2)

        val mutableList3 = mutableListOf<String>()
        mutableList3.add("Hospital de la Mujer")
        mutableList3.add("Hospital Arco Iris")
        mutableList3.add("Hospital de Clinicas")
        mutableList3.add("Hospital Materno Infantil")
        DoctoresAdapter3.addpantallaDoctores(mutableList3)
    }

    fun lp() {
        binding.recycle.apply {
            var layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = ItemDoctores
        }
        binding.recycle.apply {
            var layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = DoctoresAdapter2
        }
    }
}

private fun Unit.addpantallaDoctores(mutableList: MutableList<String>) {


}

