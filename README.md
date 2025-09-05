# Kahoot App Tech Challenge - Kacper Kiedos

Author: Kacper Kiedos

Mail: kacper2522@gmail.com

In case of any questions don't hesitate to contact me!

### How to run the application?

Application's .apk file has been uploaded to the repository. You can find it [here](https://github.com/KacperKiedos/KahootAppTechChallenge/blob/main/artifacts/kacper-kiedos-kahoot-app-tech-challenge.apk). The application can be installed on the device / emulator by using the `adb install <apk_name>` command.

### Things to improve

1. I have realized too late that "the next question should load after some time" requirement exists and I have decided not to add it. It could be implemented in the [QuizViewModel](https://github.com/KacperKiedos/KahootAppTechChallenge/blob/main/feature/quiz/src/main/java/pl/kacperkiedos/kahootapptechchallenge/quiz/screen/QuizViewModel.kt). After receving the `QuizScreenEvent.ChooseQuestion` or `QuizScreenEvent.QuestionTimerCompleted` events the corotutine with the delay could be started. When the `QuizScreenEvent.NavigateToNextQuestion` event will not be sent till delay time the ViewModel would invoke the `handleNavigationToNextQuestion` method and the question would be changed. Otherwise the timer coroutine's `Job` would be cancelled.

2. In the given API URL 10th item's type is "slider". The Figma design was focused on the regular quiz screen and so that I have intentionally decided to filter the questions which are not quiz type.

3. In the given API URL 7th items has two correct answers. In the project I have assumed that there are only questions with only one correct answer and so that in case of this question application will show that only the first question is correct. In order to support many correct answers I would need to make changes in the `QuestionState.Answered` and `QuestionState.TimerCompleted` classes. Instead of passing single `correctAnswerIndex` the indexes list should be passed.

### Application appearance
<div style="text-align: center;">  <div>
    <img src="/screenshots/1.jpg" width="200" />
    <img src="/screenshots/2.jpg" width="200" />
    <img src="/screenshots/3.jpg" width="200" />
  </div>

  <div style="margin-top: 10px; display: flex; justify-content: center; gap: 10px;">
    <img src="/screenshots/4.jpg" width="200" />
    <img src="/screenshots/5.jpg" width="200" />
  </div>
</div>


Application follows the Figma designs and the requirements provided in the task description. Besides the quiz screen I have decided to create very simple  quiz result screen which indicates that all the questions were answered. This screen also allows to start the quiz from the beginning.

### Architecture

**Application architecture consists of:**

**1. data layer**  - is responsible for fetching the data from the API and mapping it to the domain models. 

**2. domain layer** is responsible for defining the models and use-cases

**3. presentation layer** is responsible for presenting the app data and handling the user's interaction

In case of the presentation layer architecture I have chosen the Model-View-Intent which cooperates very well with the compose's declarative nature. The screen has the ViewModel class which maintains its **state** which is shared to the UI by using the Kotlin's Flow library. Possible interactions with the screen (**intent**) can be provided to the ViewModel and it could either change its state or send the information (**Effect**) to the UI to perform some action only once.

Each feature (quiz and quiz results) has its own feature module. In such small project it is of course kind of overkill, but I wanted to show how I see the properly done architecture.
