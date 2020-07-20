package com.daniellegolinsky.tictactoe.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniellegolinsky.tictactoe.R
import com.daniellegolinsky.tictactoe.ResourceProvider
import com.daniellegolinsky.tictactoe.model.BoardData
import com.daniellegolinsky.tictactoe.model.TicTacType
import javax.inject.Inject

class BoardViewModel @Inject constructor(var boardData: BoardData,
                                         var resourceProvider: ResourceProvider) : ViewModel(){

    companion object {
        const val VM_TAG = "BoardViewModel"
    }

    private var winner: TicTacType = TicTacType.UNSELECTED

    private var _xScore: MutableLiveData<Int> = MutableLiveData()
    val xScore: LiveData<Int>
        get() = _xScore

    private var _oScore: MutableLiveData<Int> = MutableLiveData()
    val oScore: LiveData<Int>
        get() = _oScore

    private var _alertMessage: MutableLiveData<String> = MutableLiveData()
    val alertMessage: LiveData<String>
        get() = _alertMessage

    private var _whoseTurn: MutableLiveData<TicTacType> = MutableLiveData()
    val whoseTurn: LiveData<TicTacType>
        get() = _whoseTurn

    private var _cellValue0: MutableLiveData<String> = MutableLiveData("")
    val cellValue0: LiveData<String>
        get() = _cellValue0

    private var _cellValue1: MutableLiveData<String> = MutableLiveData("")
    val cellValue1: LiveData<String>
        get() = _cellValue1

    private var _cellValue2: MutableLiveData<String> = MutableLiveData("")
    val cellValue2: LiveData<String>
        get() = _cellValue2

    private var _cellValue3: MutableLiveData<String> = MutableLiveData("")
    val cellValue3: LiveData<String>
        get() = _cellValue3

    private var _cellValue4: MutableLiveData<String> = MutableLiveData("")
    val cellValue4: LiveData<String>
        get() = _cellValue4

    private var _cellValue5: MutableLiveData<String> = MutableLiveData("")
    val cellValue5: LiveData<String>
        get() = _cellValue5

    private var _cellValue6: MutableLiveData<String> = MutableLiveData("")
    val cellValue6: LiveData<String>
        get() = _cellValue6

    private var _cellValue7: MutableLiveData<String> = MutableLiveData("")
    val cellValue7: LiveData<String>
        get() = _cellValue7

    private var _cellValue8: MutableLiveData<String> = MutableLiveData("")
    val cellValue8: LiveData<String>
        get() = _cellValue8


    init {
        _xScore.value = 0
        _oScore.value = 0
        _whoseTurn.value = TicTacType.X
    }

    fun newGameClicked() {
        boardData.resetBoard()
        winner = TicTacType.UNSELECTED
        _cellValue0.value = boardData.cells[0].cellStatus.toString()
        _cellValue1.value = boardData.cells[1].cellStatus.toString()
        _cellValue2.value = boardData.cells[2].cellStatus.toString()
        _cellValue3.value = boardData.cells[3].cellStatus.toString()
        _cellValue4.value = boardData.cells[4].cellStatus.toString()
        _cellValue5.value = boardData.cells[5].cellStatus.toString()
        _cellValue6.value = boardData.cells[6].cellStatus.toString()
        _cellValue7.value = boardData.cells[7].cellStatus.toString()
        _cellValue8.value = boardData.cells[8].cellStatus.toString()
    }

    fun resetScoreClicked() {
        _xScore.value = 0
        _oScore.value = 0
        boardData.resetBoard()
    }

    fun tapCell0() {
        tapCell(0)
        _cellValue0.value = boardData.cells[0].cellStatus.toString()
    }
    fun tapCell1() {
        tapCell(1)
        _cellValue1.value = boardData.cells[1].cellStatus.toString()
    }
    fun tapCell2() {
        tapCell(2)
        _cellValue2.value = boardData.cells[2].cellStatus.toString()
    }
    fun tapCell3() {
        tapCell(3)
        _cellValue3.value = boardData.cells[3].cellStatus.toString()
    }
    fun tapCell4() {
        tapCell(4)
        _cellValue4.value = boardData.cells[4].cellStatus.toString()
    }
    fun tapCell5() {
        tapCell(5)
        _cellValue5.value = boardData.cells[5].cellStatus.toString()
    }
    fun tapCell6() {
        tapCell(6)
        _cellValue6.value = boardData.cells[6].cellStatus.toString()
    }
    fun tapCell7() {
        tapCell(7)
        _cellValue7.value = boardData.cells[7].cellStatus.toString()
    }
    fun tapCell8() {
        tapCell(8)
        _cellValue8.value = boardData.cells[8].cellStatus.toString()
    }

    private fun tapCell(selectedCell: Int) {
        if (winner == TicTacType.UNSELECTED) {
            if (boardData.getMovesRemaining() != 0) {
                if (boardData.cells[selectedCell].cellStatus == TicTacType.UNSELECTED) {
                    if (selectedCell < boardData.cells.size) {
                        boardData.cells[selectedCell].cellStatus = _whoseTurn.value!!
                        _whoseTurn.value = when (_whoseTurn.value) {
                            TicTacType.X -> TicTacType.O
                            else -> TicTacType.X
                        }
                        boardData.moves++
                        var possibleWinner = boardData.checkForWinner()
                        if (possibleWinner != null && possibleWinner != TicTacType.UNSELECTED) {
                            // We have a winner
                            winner = possibleWinner!!
                            _alertMessage.value =
                                    resourceProvider.getString(R.string.wins, winner.toString())
                            when (winner) {
                                TicTacType.X -> _xScore.value = _xScore.value?.plus(1)
                                TicTacType.O -> _oScore.value = _oScore.value?.plus(1)
                            }
                        }
                    } else {
                        Log.i(VM_TAG, "Somehow the user selected an invalid cell?")
                    }
                }
                else {
                    _alertMessage.value = resourceProvider.getString(R.string.already_selected)
                }
            }
            else {
                _alertMessage.value = resourceProvider.getString(R.string.tie_game)
            }
        }
        else {
            _alertMessage.value =
                    resourceProvider.getString(R.string.start_a_new_game, winner.toString())
        }

        if (boardData.getMovesRemaining() == 0 && winner == TicTacType.UNSELECTED) {
            _alertMessage.value = resourceProvider.getString(R.string.tie_game)
        }
    }
}
