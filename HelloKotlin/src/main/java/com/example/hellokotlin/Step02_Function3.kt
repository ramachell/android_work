package com.example.hellokotlin

val nums= listOf<Int>(1,2,3,4,5,6,7,8,9,10)

fun main(){
    // nums에 3곱한걸 result로 = (3,6,9 ... 30)
    val result = nums.map {
        it*3
    }

    // 5초과만 남김
    val result2 = nums.filter {
        it>5
    }

    // 10을 곱한후 3의배수만 남기기 result3  (30 60 90)
    val result3 = nums.map { it*10 }.filter { it%3==0 }

}