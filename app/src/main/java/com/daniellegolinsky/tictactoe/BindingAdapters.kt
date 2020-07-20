package com.daniellegolinsky.tictactoe

import android.widget.Button
import androidx.databinding.BindingAdapter
import com.daniellegolinsky.tictactoe.model.TicTacType

@BindingAdapter("cellValue")
fun setCellTextColor(button: Button, cellValue: String) {
    when (cellValue) {
        TicTacType.X.toString() ->
            button.setTextColor(button.context.getColor(R.color.xTextColor))
        TicTacType.O.toString() ->
            button.setTextColor(button.context.getColor(R.color.oTextColor))
    }
}