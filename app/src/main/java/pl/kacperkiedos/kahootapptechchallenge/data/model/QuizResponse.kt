package pl.kacperkiedos.kahootapptechchallenge.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizResponse(
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("audience") val audience: String,
    @SerialName("cover") val coverImageUrl: String,
    @SerialName("creator_username") val creatorUsername: String,
    @SerialName("questions") val questions: List<QuestionResponse>,
) {
    @Serializable
    data class QuestionResponse(
        @SerialName("question") val question: String,
        @SerialName("time") val time: Int,
        @SerialName("pointsMultiplier") val pointsMultiplier: Int,
        @SerialName("image") val imageUrl: String? = null,
        @SerialName("imageMetadata") val imageMetadata: ImageMetadataResponse? = null,
        @SerialName("choices") val choices: List<ChoiceResponse>? = null,
    )

    @Serializable
    data class ChoiceResponse(
        @SerialName("answer") val answer: String,
        @SerialName("correct") val correct: Boolean,
    )

    @Serializable
    data class ImageMetadataResponse(
        @SerialName("resources") val resourceDescription: String,
    )
}
