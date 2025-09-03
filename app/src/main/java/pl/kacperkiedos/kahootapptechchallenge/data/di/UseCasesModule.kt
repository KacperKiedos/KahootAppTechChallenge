package pl.kacperkiedos.kahootapptechchallenge.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacperkiedos.kahootapptechchallenge.domain.repository.QuizRepository
import pl.kacperkiedos.kahootapptechchallenge.domain.usecase.GetQuizUseCase

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun providesGetQuizUseCase(quizRepository: QuizRepository) = GetQuizUseCase(quizRepository)
}
