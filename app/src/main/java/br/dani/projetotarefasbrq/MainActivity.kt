package br.dani.projetotarefasbrq

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.dani.projetotarefasbrq.model.Task
import br.dani.projetotarefasbrq.model.TaskListAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //chamar a tela LoginActivity
         parent as LoginActivity


        var taskList = ArrayList<Task>()
        taskList.add(Task("Exemplo de titulo","Exemplo de descrição","normal"))

        var recycle = findViewById<RecyclerView>(R.id.recycle_tasks)
        recycle.adapter = TaskListAdapter(this,taskList)
        recycle.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        var btnNew  = findViewById<Button>(R.id.btn_new_task)

        btnNew.setOnClickListener {
            val inflater = LayoutInflater.from(this)
            val inflaterView = inflater.inflate(R.layout.add_task, null)
            val taskTitle = inflaterView.findViewById<EditText>(R.id.txt_task_title)
            val taskDescription = inflaterView.findViewById<EditText>(R.id.txt_task_description)
            val taskPriority = inflaterView.findViewById<RadioGroup>(R.id.radio_priority_options)
            val addDialog = AlertDialog.Builder(this)
            addDialog.setView(inflaterView)

            addDialog.setPositiveButton("Criar") { dialog,_ ->
                val title = taskTitle.text.toString();
                val description = taskDescription.text.toString();
                val priority = when (taskPriority.checkedRadioButtonId) {
                    R.id.radio_priority_normal -> "Normal"
                    R.id.radio_priority_not_urgent -> "Not Urgent"
                    R.id.radio_priority_urgent ->"Urgent"
                    else -> "Urgent"
                }
                (recycle.adapter as TaskListAdapter).notifyDataSetChanged()
                var newTask = Task(title,description,priority)
                taskList.add(newTask)
                dialog.dismiss()
            }
            addDialog.setNegativeButton("Cancelar") { dialog,_ ->
                dialog.dismiss()
            }
            
            addDialog.create()
            addDialog.show()

        }
    }

}