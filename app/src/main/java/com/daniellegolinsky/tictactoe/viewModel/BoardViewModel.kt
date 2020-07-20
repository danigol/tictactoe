package com.daniellegolinsky.tictactoe.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniellegolinsky.tictactoe.R
import com.daniellegolinsky.tictactoe.model.BoardData
import com.daniellegolinsky.tictactoe.model.TicTacType
import javax.inject.Inject

class BoardViewModel @Inject constructor(var boardData: BoardData) : ViewModel() {

    private var _xScore: MutableLiveData<Int> = MutableLiveData()
    val xScore: LiveData<Int>
        get() = _xScore

    private var _oScore: MutableLiveData<Int> = MutableLiveData()
    val oScore: LiveData<Int>
        get() = _oScore

    private var _alertMessage: MutableLiveData<Int> = MutableLiveData()
    val alertMessage: LiveData<Int>
        get() = _alertMessage

    init {
        _xScore.value = 0
        _oScore.value = 0
    }

    fun newGameClicked() {
        boardData.resetBoard()
    }

    fun resetScoreClicked() {
        _xScore.value = 0
        _oScore.value = 0
        boardData.resetBoard()
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
        if (selectedCell < boardData.cells.size
                && boardData.cells[selectedCell].cellStatus == TicTacType.UNSELECTED) {
            boardData.cells[selectedCell].cellStatus = TicTacType.X
        }
        else {
            _alertMessage.value = R.string.already_selected
        }
    }
}