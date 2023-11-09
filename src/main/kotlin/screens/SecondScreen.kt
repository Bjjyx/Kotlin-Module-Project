package screens

import storages.Note

class SecondScreen(override val array: ArrayList<Note>) : ChooseScreen<Note>(array) {
    override fun printList() {
        println("0. Создать заметку")
        if (array.isEmpty()){
            println("====\nНет доступных заметок\n====")
        } else {
            printArray()
        }
        println("${endOfArray()}. Выход")
    }

    override fun add() {
        println("Введите название заметки")
        val noteName = scanner.nextLine()
        if (noteName.isEmpty()){
            println("Название заметки не может быть пустым")
        } else {
            println("Введите содержимое заметки")
            val noteContent = scanner.nextLine()
            if (noteContent.isEmpty()){
                println("Содержимое заметки не может быть пустым")
            } else {
                array.add(Note(noteName, noteContent))
            }
        }
    }

    override fun choose(numbOfArray: Int) {
        println(array[numbOfArray - 1].content)
    }
}