package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data.QuestionRepository

class QuestionViewModelFactory(private val questionRepository: QuestionRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuestionsViewModel(questionRepository) as T
    }
}