package com.example.a20220527_ramyamuthusamy_nycschools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220527_ramyamuthusamy_nycschools.databinding.AdapterSchoolBinding
import com.example.a20220527_ramyamuthusamy_nycschools.model.School

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var schools = mutableListOf<School>()

    var onItemClick : ((School) -> Unit)? = null
    fun setSchoolList(schools:List<School>){
        this.schools = schools.toMutableList()
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        // Create a new view, which defines the UI of the list item
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterSchoolBinding.inflate(inflater,parent,false)
        return MainViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val school = schools[position]
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.binding.tvDbn.text = school.dbn
        holder.binding.tvSchoolName.text = school.schoolName
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(school)
        }
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return schools.size
    }
}

/**
 * Provide a reference to the type of views that you are using
 * (custom ViewHolder).
 */
class MainViewHolder(val binding : AdapterSchoolBinding): RecyclerView.ViewHolder(binding.root) {

}
