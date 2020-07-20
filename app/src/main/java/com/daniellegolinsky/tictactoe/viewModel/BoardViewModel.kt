package com.daniellegolinsky.tictactoe.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class BoardViewModel @Inject constructor() : ViewModel() {

    private var _xScore: MutableLiveData<Int> = MutableLiveData()
    val xScore: LiveData<Int>
        get() = _xScore

    private var _oScore: MutableLiveData<Int> = MutableLiveData()
    val oScore: LiveData<Int>
        get() = _oScore

    init {
        _xScore.value = 0
        _oScore.value = 0
    }

    fun newGameClicked() {

    }

    fun resetScoreClicked() {

    }

    fun tapCell0() {
        tapCell(0)
    }
    fun tapCell1() {
        tapCell(1)
    }
    fun tapCell2() {
        tapCell(2)
    }
    fun tapCell3() {
        tapCell(3)
    }
    fun tapCell4() {
        tapCell(4)
    }
    fun tapCell5() {
        tapCell(5)
    }
    fun tapCell6() {
        tapCell(6)
    }
    fun tapCell7() {
        tapCell(7)
    }
    fun tapCell8() {
        tapCell(8)
    }

    private fun tapCell(selectedCell: Int) {
        Log.i("TEST", "Hey, you clicked me with: $selectedCell")
    }
}