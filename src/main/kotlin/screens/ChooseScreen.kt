package screens

import storages.Storage
import java.util.InputMismatchException
import java.util.Scanner


abstract class ChooseScreen<T: Storage>(open val array: ArrayList<T>){
    var scanner = Scanner(System.`in`)
    var commandStr = ""

    fun endOfArray() : Int{
        return array.size + 1
    }

    fun printArray(){
        array.forEachIndexed{ index, value -> println("${index + 1}. ${value.name}") }
    }

    abstract fun printList()

    abstract fun add()

    abstract fun choose(numbOfArray: Int)

    fun userInterface(){
        var commandInt = -1
        while (commandInt != endOfArray()){
            printList()
            try {
                commandInt = scanner.nextInt()
                scanner.skip("\n")
                if(commandInt >= 0 && commandInt <= endOfArray()){
                    when(commandInt){
                        0 -> add()
                        in 1 until endOfArray() -> choose(commandInt)
                    }
                } else {
                    println("Введено число выходящее за рамки списка")
                }
            } catch (exception: InputMismatchException){
                println("Необходимо ввести целое число")
                scanner.skip(".*\n")
            }
        }
    }

}
