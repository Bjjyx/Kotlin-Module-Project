package screens

import storages.Note
import java.util.Scanner

class ChooseNote(override val array: ArrayList<Note>, override val scanner: Scanner) : ChooseMenuScreen<Note>(array, scanner) {
    override fun showIfEmpty() {
        println("====\nНет доступных заметок\n====")
    }

    override fun showFirstStr() {
        println("0. Создать заметку")
    }

    override fun addElement() {
        println("Введите название заметки")
        val noteName = scanner.nextLine()
        when(noteName.isBlank()){
            true -> println("!!!\nНазвание заметки не может быть пустым\n!!!")
            false -> {
                println("Введите содержимое заметки")
                command = scanner.nextLine()
                when(command.isBlank()){
                    true -> println("!!!\nСодержимое заметки не может быть пустым\n!!!")
                    false -> array.add(Note(noteName, command))
                }
            }
        }
    }

    override fun selectElement() {
        println("\n${array[command.toInt() - 1].getContent()}\n")
    }
}