package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data

data class Question(
    val id: Int,
    val questionText: String,
    val correctAnswer: Boolean,
    var isCorrect: Boolean? = null
) {
    override fun toString(): String {
        return "Question(id=$id, questionText='$questionText', correctAnswer='$correctAnswer', isCorrect=$isCorrect)"
    }
}