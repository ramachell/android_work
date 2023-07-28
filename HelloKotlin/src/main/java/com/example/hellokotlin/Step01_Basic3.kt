package com.example.hellokotlin


// Kotlin 에서의 배열과 반복문

fun main() {
    // listOf 안에 데이터로 추론 되기때문에 List<String> 생략이 가능
    val names = listOf("111","222","333")
    val names2:List<String> = listOf("111","222","333")

    val animals = listOf<String>("dog", "cat","monkey")
    val nums = listOf<Int>(10,20,30)
    // 배열의 참조
    println(names[0])
    println(names[1])
    println(names[2])

    // 수정 불가
    // names[0]="1"

    // indices 는 index 의 복수형 names 배열의 index로 이루어진 배열
    println("-----------------")
    val result = names.indices

    for (i in names.indices){
        println(i)
    }
    println("---------------")
    for (i in names.indices){
        println(names[i])
    }
    println("-----------------")
    for (i in names.indices){
        println("$i : ${names[i]}")
    }
    println("-----------------")
    for (item in names){
        println(item)
    }
    println("-----------------")
    names.forEach {
        println(it)
    }
}