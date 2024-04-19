package com.cupp.msu.criminalintentchapter9a

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import java.util.Date
import java.util.UUID
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val TAG = "CrimeListViewModel"
private val crimeRepository = CrimeRepository.get()
class CrimeListViewModel : ViewModel() {


    private val _crimes: MutableStateFlow<List<Crime>> = MutableStateFlow(emptyList())
    val crimes: StateFlow<List<Crime>>
        get() = _crimes.asStateFlow()


    init {

        viewModelScope.launch {
            crimeRepository.getCrimes().collect {

            }
        }
    }
}