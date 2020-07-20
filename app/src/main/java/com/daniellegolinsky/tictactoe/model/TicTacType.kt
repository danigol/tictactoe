package com.daniellegolinsky.tictactoe.model

enum class TicTacType (var value: Int){
    UNSELECTED(-1),
    X(0),
    O(1);

    override fun toString(): String {
        return when (value) {
            0 -> "X"
            1 -> "O"
            else -> ""
        }
    }
}