package com.daniellegolinsky.tictactoe.model

class BoardCell(val position: Int) {
    var cellStatus: TicTacType = TicTacType.UNSELECTED
}