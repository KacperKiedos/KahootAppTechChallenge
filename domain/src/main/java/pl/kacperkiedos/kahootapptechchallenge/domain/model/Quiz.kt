package pl.kacperkiedos.kahootapptechchallenge.domain.model

data class Quiz(
    val title: String,
    val description: String,
    val audienceType: String,
    val coverImageUrl: String,
    val creatorUsername: String,
    val questions: List<Question>,
)
