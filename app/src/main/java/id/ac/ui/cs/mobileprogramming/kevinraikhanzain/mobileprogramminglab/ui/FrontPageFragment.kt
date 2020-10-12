package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.R
import kotlinx.android.synthetic.main.front_page_fragment.*

class FrontPageFragment : Fragment() {
    private var viewModel: QuestionsViewModel? = null
    private var currentScore : Int = 0

    fun setViewModel(vm: QuestionsViewModel) {
        viewModel = vm
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("LOGNYA", "onCreate() DetailFragment")


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.front_page_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("LOGNYA", "onViewCreated() FrontPageFragment")
        initUi()
    }

    fun initUi() {

        textViewScoreAmount.text = currentScore.toString()


        button1.setOnClickListener {
            viewModel!!.chosenQuestionId.value = 1
            (activity as MainActivity).replaceFragmentWithDetail()
        }

        button2.setOnClickListener {
            viewModel!!.chosenQuestionId.value = 2
            (activity as MainActivity).replaceFragmentWithDetail()
        }

        button3.setOnClickListener {
            viewModel!!.chosenQuestionId.value = 3
            (activity as MainActivity).replaceFragmentWithDetail()
        }

        viewModel!!.score.observe(activity!!, Observer { scoreValue ->
//            var counter = 0
//            questions.forEach {
////                    textViewQuestionTitle.text.toString() + "( ${it.toString()} )"
//                if (it.isCorrect == true) {
//                    counter++
//                }
//            }
            currentScore = scoreValue

        })
    }
}