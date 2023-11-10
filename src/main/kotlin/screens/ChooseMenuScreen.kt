package screens

import storages.Storage
import java.util.Scanner
//Обощенный класс для работы с меню выбора
abstract class ChooseMenuScreen<T: Storage>(open val array: ArrayList<T>, open val scanner: Scanner) {
    var command = ""
    //Все абстрактные функции переопределяются в наследниках из-за невозможности обобщить код
    //Функция для вывода фразы о пустом хранилище
    abstract fun showIfEmpty()
    //Функция для вывода первой строки меню
    abstract fun showFirstStr()
    //Добавление елементов
    abstract fun addElement()
    //Выбор элемента из списка доступных
    abstract fun selectElement()
    //Получение длинны списка меню
    private fun getEndOfListMenu() : Int{
        return array.size + 1
    }
    //Показывает список доступных выборов в меню
    private fun showListMenu(){
        showFirstStr()
        if (array.isEmpty()){
            showIfEmpty()
        } else {
            array.forEachIndexed { index, value -> println("${index + 1}. ${value.name}") }
        }
        println("${getEndOfListMenu()}. Выход")
    }
    //Функция для взаимодействия с пользователем и для запуска приложения в целом
    fun interactionWithUser(){
        while (true){
            showListMenu()
            command = scanner.nextLine()
            try{
                if(command.toInt() in 0..getEndOfListMenu()){
                    when(command.toInt()){
                        0 -> addElement()
                        in 1 until getEndOfListMenu() -> selectElement()
                        getEndOfListMenu() -> break
                    }
                } else {
                    println("!!!\nВведено число выходящее за рамки списка\n!!!")
                }
            } catch (exception: NumberFormatException){
                println("!!!\nНеобходимо ввести целое число\n!!!")
            }
        }
    }
}