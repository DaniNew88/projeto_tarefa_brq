package br.dani.projetotarefasbrq.model

import java.util.*

class Task (var title : String, var description : String, var priority: String){
    private var status: Boolean
    private lateinit var date : Date
    var dateFormat = ("dd/M/yyyy")
    init {
        var date = dateFormat.format(Date())
        this.status = false
    }

}