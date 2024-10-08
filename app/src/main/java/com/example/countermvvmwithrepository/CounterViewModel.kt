package com.example.countermvvmwithrepository

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.countermvvmwithrepository.data.CounterRepository
import androidx.lifecycle.viewmodel.compose.viewModel

class CounterViewModel(): ViewModel() {
    private val repository: CounterRepository = CounterRepository()
    private val _count = mutableIntStateOf(repository.getCounter().count)
    val count : MutableState<Int> = _count
    fun increment() {
        repository.increment()
        _count.value = repository.getCounter().count
    }

    fun decrement() {
        repository.decrement()
        _count.value = repository.getCounter().count
    }
}