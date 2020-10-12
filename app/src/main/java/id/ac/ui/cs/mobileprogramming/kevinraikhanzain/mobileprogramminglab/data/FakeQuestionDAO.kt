package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuestionDAO {
    private val questionList = mutableListOf<Question>()
    private val questions = MutableLiveData<List<Question>>()

    init {
        questions.value = questionList
    }

    fun addQuestion(question: Question) {
        questionList.add(question)
        questions.value = questionList
    }

    fun getQuestions() = questions as LiveData<List<Question>>

//    fun getQuestionFromId(id: Int): LiveData<Question>? {
//        questionList.forEach {
//            if (it.id == id) {
//                return it as LiveData<Question>
//            }
//        }
//        return null
//    }

    fun answerQuestion(id: Int, ans: Boolean) {
        questionList.forEach {
            if (it.id == id) {
                it.isCorrect = ans == it.correctAnswer
            }
        }
        questions.value = questionList
    }
}