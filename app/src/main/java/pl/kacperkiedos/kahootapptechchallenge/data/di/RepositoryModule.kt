package pl.kacperkiedos.kahootapptechchallenge.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacperkiedos.kahootapptechchallenge.data.repository.QuizRepositoryImpl
import pl.kacperkiedos.kahootapptechchallenge.domain.repository.QuizRepository

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {
    @Binds
    abstract fun bindsQuizRepository(quizRepositoryImpl: QuizRepositoryImpl): QuizRepository
}
