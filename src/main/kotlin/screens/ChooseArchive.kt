package screens

import storages.Archive
import java.util.Scanner

class ChooseArchive(override val array: ArrayList<Archive>, override val scanner: Scanner) : ChooseMenuScreen<Archive>(array, scanner) {
    override fun showIfEmpty() {
        println("====\nНет доступных архивов\n====")
    }

    override fun showFirstStr() {
        println("0. Создать архив")
    }

    override fun addElement() {
        println("Введите название архива")
        command = scanner.nextLine()
        when(command.isBlank()){
            true -> println("!!!\nНазвание архива не может быть пустым\n!!!")
            false -> array.add(Archive(command))
        }
    }

    override fun selectElement() {
        ChooseNote(array[command.toInt() - 1].getArray(), scanner).interactionWithUser()
    }
}