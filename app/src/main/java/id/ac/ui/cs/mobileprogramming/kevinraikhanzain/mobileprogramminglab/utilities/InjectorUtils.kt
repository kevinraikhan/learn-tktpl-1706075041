package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.utilities

import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data.FakeDatabase
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data.Question
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data.QuestionRepository
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.ui.QuestionViewModelFactory

object InjectorUtils {
    fun provideQuestionViewModelFactory(): QuestionViewModelFactory {
        val questionRepository = QuestionRepository.getInstance(FakeDatabase.getInstance().questionDao)
        questionRepository.addQuestion(Question(1, "1 + 2 = 3", true))
        questionRepository.addQuestion(Question(2, "3 + 2 = 99", false))
        questionRepository.addQuestion(Question(3, "10 * 10 = 100", true))
        return QuestionViewModelFactory(questionRepository)
    }
}