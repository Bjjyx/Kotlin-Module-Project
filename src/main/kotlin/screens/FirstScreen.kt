package screens

import storages.Archive

class FirstScreen(override val array: ArrayList<Archive>) : ChooseScreen<Archive>(array){
    override fun printList() {
        println("0. Создать архив")
        if (array.isEmpty()){
            println("====\nНет доступных архивов\n====")
        } else {
            printArray()
        }
        println("${endOfArray()}. Выход")
    }

    override fun add() {
        println("Введите название архива")
        commandStr = scanner.nextLine()
        if(commandStr.isEmpty()){
            println("Название архива не может быть пустым")
        } else {
            array.add(Archive(commandStr))
        }
    }

    override fun choose(numbOfArray: Int) {
        SecondScreen(array[numbOfArray - 1].noteArray).userInterface()
    }

}