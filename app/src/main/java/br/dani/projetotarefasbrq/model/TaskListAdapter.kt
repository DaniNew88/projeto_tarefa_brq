package br.dani.projetotarefasbrq.model

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import br.dani.projetotarefasbrq.R

class TaskListAdapter (var ctx : Context, var taskList : ArrayList<Task>) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title : TextView
        var desc : TextView
        var bg : View
        init {
            title = view.findViewById(R.id.txt_title);
            desc = view.findViewById(R.id.txt_description);
            bg = view.findViewById(R.id.bg)
        }

        private fun openPopUp(view : View) {
            val popup = PopupMenu(view.context, view)
            val inflater : MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.task_options,popup.menu)
            popup.show()
        }
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = taskList[position].title
        holder.desc.text = taskList[position].description
        holder.bg.setBackgroundResource( when(taskList[position].priority) {
            "Normal" -> R.color.normal
            "Not urgent" -> R.color.not_urgent
            "Urgent" -> R.color.urgent
            else -> R.color.urgent
        })

    }

    override fun getItemCount(): Int {
       return taskList.size
    }

}
