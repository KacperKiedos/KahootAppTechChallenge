package pl.kacperkiedos.kahootapptechchallenge.domain.model

data class Question(
    val questionText: String,
    val time: Int,
    val pointsMultiplier: Int,
    val type: QuestionType,
    val imageUrl: String?,
    val resourceDescription: String?,
    val choices: List<Choice>,
)
