package pl.kacperkiedos.kahootapptechchallenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<STATE : State, EVENT : Event>(
    initialState: STATE
) : ViewModel() {
    private var mutableStateFlow = MutableStateFlow(initialState)
    val stateFlow: StateFlow<STATE> = mutableStateFlow

    abstract fun onEvent(event: EVENT)

    protected open fun updateState(block: STATE.() -> STATE) = mutableStateFlow.update(block)
}
