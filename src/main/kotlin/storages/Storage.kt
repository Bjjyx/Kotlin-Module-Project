package storages


abstract class Storage(open val name: String)

data class Archive(override val name: String) : Storage(name){
    private val array: ArrayList<Note> = arrayListOf()

    fun getArray() : ArrayList<Note>{
        return array
    }
}

data class Note(override val name: String,private val content: String) : Storage(name){
    fun getContent() : String{
        return content
    }
}