package com.daniellegolinsky.tictactoe.model

import com.daniellegolinsky.tictactoe.ToeBoard
import com.daniellegolinsky.tictactoe.ToeCell

class BoardData() {
    companion object {
        const val TOTAL_MOVES = 9
        const val WIDTH = 3
        const val HEIGHT = 3
    }

    var moves: Int = 0
    var cells: MutableList<BoardCell> = mutableListOf()

    init {
        for (i in 0..8) {
            cells.add(BoardCell(i))
        }
    }

    fun setCellValue(whichCell: Int, status: TicTacType) {
        if (whichCell < cells.size) {
            cells[whichCell].cellStatus = status
        }
    }

    fun playerMoved() {
        moves++
    }

    fun getMovesRemaining(): Int {
        return TOTAL_MOVES - moves
    }

    fun resetBoard() {
        moves = 0
    }

    fun boardSide(): Int {
        return cells.size
    }

    fun checkForWinner(): TicTacType? {
        // 5 is the minimum number of moves anyway
        if (moves > 4) {
            val rows: TicTacType = checkRows()
            if (rows != TicTacType.UNSELECTED) {
                return rows
            }
            val columns: TicTacType = checkColumns()
            if (columns != TicTacType.UNSELECTED) {
                return columns
            }
            val diagonally: TicTacType = checkDiagonally()
            if (diagonally != TicTacType.UNSELECTED) {
                return diagonally
            }
        }
        return TicTacType.UNSELECTED
    }

    private fun checkRows(): TicTacType {
        var winner: TicTacType = TicTacType.UNSELECTED
        var cell: TicTacType
        var y = 0
        while (y < cells.size) {
            cell = cells[y].cellStatus
            if (cell == TicTacType.UNSELECTED) {
                y += HEIGHT
                continue
            }
            val nextCell: TicTacType = cells[y + 1].cellStatus
            val lastCell: TicTacType = cells[y + 2].cellStatus
            if (cell == nextCell && cell == lastCell) {
                winner = cell
                break
            }
            y += HEIGHT
        }
        return winner
    }

    private fun checkColumns(): TicTacType {
        var winner: TicTacType = TicTacType.UNSELECTED
        var cell: TicTacType
        for (x in 0 until WIDTH) {
            cell = cells[x].cellStatus
            if (cell == TicTacType.UNSELECTED) {
                continue
            }
            val nextCell: TicTacType = cells[x + WIDTH].cellStatus
            val lastCell: TicTacType = cells[x + WIDTH * 2].cellStatus
            if (cell == nextCell && cell == lastCell) {
                winner = cell
                break
            }
        }
        return winner
    }

    private fun checkDiagonally(): TicTacType {
        val topLeft: TicTacType = cells[0].cellStatus
        val center: TicTacType = cells[4].cellStatus // TODO Oh, I don't like constants like this.
        val topRight: TicTacType = cells[WIDTH - 1].cellStatus
        val bottomLeft: TicTacType = cells[6].cellStatus
        val bottomRight: TicTacType = cells[8].cellStatus
        if (topLeft == center && topLeft == bottomRight) {
            return topLeft
        }
        return if (topRight == center && topRight == bottomLeft) {
            topRight
        }
        else {
            TicTacType.UNSELECTED
        }
    }

}