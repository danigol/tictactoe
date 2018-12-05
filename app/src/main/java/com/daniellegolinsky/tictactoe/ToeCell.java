package com.daniellegolinsky.tictactoe;

/**
 * Created by Danielle on 12/2/18.
 */

public class ToeCell {

    enum TicTacType {
        UNSELECTED(-1),
        X(0),
        O(1);

        int value;

        public String toString() {
            if (value == 0) {
                return "X";
            }
            else if (value == 1){
                return "O";
            }
            else
                return "";
        }

        TicTacType(int i) {
            this.value = i;
        }
    }

    // An integer, 0-8
    private final int position;
    private TicTacType currentValue;


    public ToeCell(int p) {
        this.position = p;
        this.currentValue = TicTacType.UNSELECTED;
    }

    public TicTacType getCurrentValue() {
        return this.currentValue;
    }

    public void setCurrentValue(final TicTacType value) {
        this.currentValue = value;
    }
}
