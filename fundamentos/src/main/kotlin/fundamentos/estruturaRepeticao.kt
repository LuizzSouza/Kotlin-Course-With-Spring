package fundamentos

fun main() {
//    print1a10()
//    print1a10inverse()
//    print1a10step2()
//    printRangeGustavo()
//    printRange(IntRange(1, 10))
//    printRangeDownTo(IntRange(1, 10))
    whileMenorQue10()
    doWhileMenorQue10()
}

fun whileMenorQue10() {
    var x = 0
    while (x < 10) {
        println(x)
        x++
    }
}

fun doWhileMenorQue10() {
    var x = 10
    do {
        println(x)
        x++
    } while (x < 10)
}

fun print1a10() {
    for (i in 1..10) {
        println(i)
    }
}

fun print1a10inverse() {
    for (i in 10 downTo 1) {
        println(i)
    }
}

fun print1a10step2() {
    for (i in 2..10 step 2) {
        println(i)
    }
}

fun printRangeGustavo(init: Int, final: Int) {
    for (i in init..final) {
        println(i)
    }
}

fun printRange(range: IntRange) {
    for (i in range) {
        println(i)
    }
}

fun printRangeDownTo(range: IntRange) {
    for (i in range.reversed()) {
        println(i)
    }
}