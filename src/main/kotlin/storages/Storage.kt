package storages

abstract class Storage(open val name: String)

data class Archive(override val name: String) : Storage(name){
    val noteArray: ArrayList<Note> = arrayListOf()
}

data class Note(override val name: String, val content: String) : Storage(name)
