package adapter

import android.content.Context
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.test.espresso.core.internal.deps.guava.collect.Iterators.addAll
import com.grupod.am.PantallaDoctores
import com.grupod.am.R
import com.grupod.am.databinding.ActivityItemDoctoresBinding

class DoctoresAdapter :
    RecyclerView.Adapter<DoctoresAdapter.PantallaDoctoresViewHolder> (){

    private val pantallaDoctores = mutableListOf<String>()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PantallaDoctoresViewHolder{
        context = parent.context
        return PantallaDoctoresViewHolder(
            ActivityItemDoctoresBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PantallaDoctoresViewHolder, position:Int) {
        holder.binding(pantallaDoctores[position])
    }
    override fun getItemCount(): Int = pantallaDoctores.size

    inner class PantallaDoctoresViewHolder(private val binding: ActivityItemDoctoresBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun binding(data: String) {
            binding.FullName.text = data
            binding.Especialidad.text = data
            binding.Trabajo.text = data
            binding.user.setImageResource(R.drawable.userdoc)
        }
    }
    fun addPantallaDoctores(list: List<String>){
        PantallaDoctores.clear()
        PantallaDoctores.addAll(list)
    }
}