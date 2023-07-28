package com.example.hellokotlin


var a:(String)->Unit=fun(str):Unit{}

var d = fun(a:()->Unit){
    a()
}

fun main(){
    d(){fun(){
        println("aaa")
    }

    }
}