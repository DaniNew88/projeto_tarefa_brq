package br.dani.projetotarefasbrq.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.dani.projetotarefasbrq.R

class TaskListAdapter (var ctx : Context, var taskList : ArrayList<Task>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return taskList.size
    }


}
class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

}