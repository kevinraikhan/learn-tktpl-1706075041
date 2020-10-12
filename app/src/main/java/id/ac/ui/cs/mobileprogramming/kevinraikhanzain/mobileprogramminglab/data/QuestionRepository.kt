package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data

class QuestionRepository private constructor(private val questionDAO: FakeQuestionDAO){

    fun addQuestion(question: Question) {
        questionDAO.addQuestion(question)

    }

    fun getQuestion() = questionDAO.getQuestions()

    companion object {
        @Volatile private var instance: QuestionRepository? = null

        fun getInstance(questionDao: FakeQuestionDAO) = instance ?: synchronized(this) {
            instance ?: QuestionRepository(questionDao).also { instance = it }
        }

    }
}