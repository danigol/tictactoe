package com.daniellegolinsky.tictactoe

import android.widget.Button
import androidx.databinding.BindingAdapter

@BindingAdapter("cellValue")
fun setCellTextColor(button: Button, cellValue: String) {
    when (cellValue) {
        ToeCell.TicTacType.X.toString() ->
            button.setTextColor(button.context.getColor(R.color.xTextColor))
        ToeCell.TicTacType.O.toString() ->
            button.setTextColor(button.context.getColor(R.color.oTextColor))
    }
}