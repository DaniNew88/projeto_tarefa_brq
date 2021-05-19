package br.dani.projetotarefasbrq.model

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.brq.tarefas.R
import com.brq.tarefas.model.Prioritys
import com.brq.tarefas.model.Task
import java.util.zip.Inflater

class TaskListAdapter (var ctx : Context, var taskList : ArrayList<Task>) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       val txtTitle : TextView
       val txtDesc : TextView
       val layoutBg : View
       val btnMore : ImageButton
        init {
            txtTitle = view.findViewById(R.id.txt_task_title)
            txtDesc = view.findViewById(R.id.txt_task_description)
            layoutBg = view.findViewById(R.id.view_task_background)
            btnMore = view.findViewById(R.id.btn_more)
        }
    }
    @SuppressLint("ResourceType")
    fun popUp(ctx: Context, view : View, id : Int) {
        val popupMenus = PopupMenu(ctx,view)
        popupMenus.inflate(R.menu.task_options)
        popupMenus.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.task_delete -> {
                    AlertDialog.Builder(ctx)
                        .setTitle("Apagar")
                        .setMessage("Você tem certeza que deseja apagar ?")
                        .setPositiveButton("Sim"){
                                dialog,_->
                            taskList.removeAt(id)
                            notifyDataSetChanged()
                            Toast.makeText(ctx,"A tarefa foi apagada !",Toast.LENGTH_SHORT).show()
                            dialog.dismiss()
                        }
                        .setNegativeButton("Não"){
                                dialog,_->
                            dialog.dismiss()
                        }
                        .create()
                        .show()

                    true
                }
                R.id.task_edit -> {
                    val inflateView = LayoutInflater.from(ctx).inflate(R.layout.add_task,null)
                    val title = inflateView.findViewById<EditText>(R.id.txt_add_task_screen_title)
                    val description = inflateView.findViewById<EditText>(R.id.txt_add_task_screen_description)
                    title.setText(taskList[id].title)
                    description.setText(taskList[id].description)
                    AlertDialog.Builder(ctx)
                        .setView(inflateView)
                        .setPositiveButton("Ok"){
                                dialog,_->
                            taskList[id].title = title.text.toString()
                            taskList[id].description = description.text.toString()

                            notifyDataSetChanged()
                            Toast.makeText(ctx,"Tarefa alterada !",Toast.LENGTH_SHORT).show()
                            dialog.dismiss()
                        }
                        .setNegativeButton("Cancelar"){
                                dialog,_->
                            dialog.dismiss()
                        }
                        .create()
                        .show()
                    true
                }

                else -> true
            }
        }
        popupMenus.show()

    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitle.text = taskList[position].title
        holder.txtDesc.text = taskList[position].description
        holder.layoutBg.setBackgroundResource(taskList[position].color)
        holder.btnMore.setOnClickListener {
            popUp(it.context, it, position)
        }
    }
    override fun getItemCount(): Int {
        return taskList.size
    }

}
