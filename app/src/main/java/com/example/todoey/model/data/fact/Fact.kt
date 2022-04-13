package com.example.todoey.model.data.fact


// Use only val inside data class, using var under data class should be avoided
data class Fact(
    var id : String,
    var text  :String,
    var source : String,
    var source_url : String,
    var language : String,
    var permalink : String
)
