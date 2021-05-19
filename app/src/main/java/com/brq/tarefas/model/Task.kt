package com.brq.tarefas.model

import com.brq.tarefas.R

class Task(var title: String,
           var description: String,
           priority: Prioritys){
     var status : Boolean = false
     var color : Int;
    init {
        if (priority == Prioritys.URGENT) {
            this.color =  R.color.urgent
        }else if (priority == Prioritys.IMPORTANT) {
            this.color = R.color.important
        }else {
           this.color = R.color.normal
        }
    }



}