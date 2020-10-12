package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data.Question
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data.QuestionRepository

class QuestionsViewModel(private val questionRepository: QuestionRepository) : ViewModel() {
    var chosenQuestionId: MutableLiveData<Int> = MutableLiveData<Int>()
    var score: MutableLiveData<Int> = MutableLiveData<Int>()


    fun getQuestions() = questionRepository.getQuestion()

    fun addQuestion(question: Question) = questionRepository.addQuestion(question)

    fun answerQuestion(question: Question, answer: Boolean) {
        var prevAns = question.isCorrect
        question.isCorrect = question.correctAnswer == answer

        if (prevAns != question.isCorrect) {
            if (question.isCorrect!!) {
                this.score.value = (this.score.value ?: 0) + 1
            } else {
                this.score.value = (this.score.value ?: 0) - 1
            }
        }

    }


}