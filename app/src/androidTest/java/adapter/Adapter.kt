package adapter

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.Prefere
import com.grupod.am.ItemDoctores
import com.grupod.am.databinding.ActivityItemDoctoresBinding
import kotlin.coroutines.coroutineContext

class Adapter: RecyclerView.Adapter<Adapter.AdapterViewHolder> (){
    private val adapter= mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder=AdapterViewHolder(
        ActivityItemDoctoresBinding.inflate(
            LayoutInflater.from(parent, context),
            parent,
            false
        )
    )
    override fun onBindViewHolder(holder: AdapterViewHolder, position:Int) {
        holder.binding(adapter[position])
    }
    override fun getItemCount(): Int = Adapter.size
    inner class AdapterViewHolder(binding.root){
        fun binding(data: String){
            binding.textViewName.text= data
        }
    }
    fun addAdapter(list: List<String>){
        adapter.clear()
        adapter.addAll(list)
    }
}