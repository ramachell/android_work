package com.example.hellokotlin

class MyCar

class YourCar{
    fun drive(){
        print("aaa")
    }
}
// 대표 생성자는 클래명 오른쪽
class ship constructor(){
    init{
        // 객채 생성시 초기화하고픈 작업 여기서
        println("ship 클래스 init");
    }
}
class ship2 () {
    init{
        // 객채 생성시 초기화하고픈 작업 여기서
        println("ship 클래스 init");
    }
}

class ship3 {
    init{
        // 객채 생성시 초기화하고픈 작업 여기서
        println("ship 클래스 init");
    }
}

fun main(){
    // MyCar 클래스 생성
    // var c1:MyCar = MyCar()
    var c1 = MyCar()
    var c2 =YourCar()

    c2.drive()
}