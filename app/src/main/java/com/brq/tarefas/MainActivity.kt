package com.brq.tarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.RenderScript
import android.view.LayoutInflater
import android.widget.Adapter
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.dani.projetotarefasbrq.model.TaskListAdapter
import com.brq.tarefas.model.Task
import com.brq.tarefas.model.Prioritys
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var taskList = ArrayList<Task>()
        taskList.add(Task(getString(R.string.task_description_example),getString(R.string.task_title_example), Prioritys.NORMAL))


        var recycleMain = findViewById<RecyclerView>(R.id.recycle_main);
        recycleMain.adapter  = TaskListAdapter(this, taskList);
        val adapterRecycle = recycleMain.adapter;


        recycleMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        var btnAdd = findViewById<FloatingActionButton>(R.id.floating_add_task)
        btnAdd.setOnClickListener {
                val inflater = LayoutInflater.from(this)
                val inflaterView = inflater.inflate(R.layout.add_task, null)
                val txtTaskTitle = inflaterView.findViewById<EditText>(R.id.txt_add_task_screen_title)
                val txtTaskDescription = inflaterView.findViewById<EditText>(R.id.txt_add_task_screen_description)
                val radioTaskPriority = inflaterView.findViewById<RadioGroup>(R.id.radio_priority_options)
                val newDialog = AlertDialog.Builder(this)
                newDialog.setView(inflaterView)
                newDialog.setPositiveButton("Salvar") { dialog,_ ->
                    val txtNewTitle = txtTaskTitle.text.toString()
                    val txtNewDescription = txtTaskDescription.text.toString()
                    val priority = when (radioTaskPriority.checkedRadioButtonId) {
                        R.id.radio_normal -> Prioritys.NORMAL
                        R.id.radio_important -> Prioritys.IMPORTANT
                        R.id.radio_urgent ->  Prioritys.URGENT
                        else -> Prioritys.NORMAL
                    }

                    if (!txtNewTitle.isNullOrBlank() && !txtNewDescription.isNullOrEmpty()) {
                        taskList.add(Task(txtNewTitle,txtNewDescription,priority))
                        //(recycleMain.adapter as Adapter).notifyDataSetChanged()
                    }
                    dialog.dismiss()

                }
                newDialog.setNegativeButton(getString(R.string.task_cancel)) {
                    dialog,_ ->
                    dialog.dismiss()
                }
            newDialog.create()
            newDialog.show()

        }

    }
}