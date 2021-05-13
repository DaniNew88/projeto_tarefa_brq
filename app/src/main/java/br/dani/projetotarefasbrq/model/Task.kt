package br.dani.projetotarefasbrq.model

class Task (var title : String, var description : String, var status : Boolean, var priority: String){
    init {
        this.status = false
    }

}