package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.R
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment() {
    private var viewModel: QuestionsViewModel? = null

    fun setViewModel(vm: QuestionsViewModel) {
        viewModel = vm
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("LOGNYA", "onCreate() DetailFragment")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("LOGNYA", "onViewCreated() DetailFragment")
        viewModel!!.getQuestions().observe(activity!!, Observer { questions ->

            Log.d("LOGNYA", "onViewCreated() DetailFragment NEXT" + questions)
            questions.forEach { question ->
                if (question.id == viewModel!!.chosenQuestionId.value) {
                    textViewQuestionText.text = question.questionText
                    buttonTrue.setOnClickListener {
                        viewModel!!.answerQuestion(question, true)
                    }

                    buttonFalse.setOnClickListener {
                        viewModel!!.answerQuestion(question, false)
                    }
                }
            }

        })
    }
}