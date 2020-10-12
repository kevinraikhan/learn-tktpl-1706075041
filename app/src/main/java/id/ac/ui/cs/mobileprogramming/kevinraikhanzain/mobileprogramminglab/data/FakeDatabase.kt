package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data

class FakeDatabase private constructor(){
    val questionDao = FakeQuestionDAO()
    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }

    }
}