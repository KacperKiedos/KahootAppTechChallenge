package pl.kacperkiedos.kahootapptechchallenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

abstract class BaseViewModel<STATE : State, EVENT : Event, EFFECT: Effect>(
    initialState: STATE
) : ViewModel() {
    private var mutableStateFlow = MutableStateFlow(initialState)
    val stateFlow: StateFlow<STATE> = mutableStateFlow

    private val effectChannel = Channel<EFFECT>(Channel.BUFFERED)
    val effectFlow: Flow<EFFECT> = effectChannel.receiveAsFlow()
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
        )

    abstract fun onEvent(event: EVENT)

    protected suspend fun pushEffect(effect: EFFECT) {
        withContext(Dispatchers.Main) {
            effectChannel.trySend(effect)
        }
    }

    protected open fun updateState(block: STATE.() -> STATE) = mutableStateFlow.update(block)
}
