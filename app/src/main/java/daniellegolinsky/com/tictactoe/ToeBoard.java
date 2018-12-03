package daniellegolinsky.com.tictactoe;

import java.util.ArrayList;
import java.util.List;

import daniellegolinsky.com.tictactoe.ToeCell.TicTacType;

/**
 * Created by Danielle on 12/2/18.
 */

public class ToeBoard {

    private static final int TOTAL_MOVES = 9;
    private static final int BOARD_SIZE = 9;
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;
    
    private int moves = 0;
    private List<ToeCell> cells;

    public ToeBoard() {
        cells = new ArrayList<ToeCell>();
        for (int i = 0; i < 9; i++) {
            cells.add(new ToeCell(i));
        }
    }

    public ToeCell get(int i) {
        return cells.get(i);
    }

    public void set(int cell, ToeCell.TicTacType type) {
        cells.get(cell).setCurrentValue(type);
        move();
    }

    private void move() {
        this.moves++;
    }

    public int getMovesRemaining() {
        return TOTAL_MOVES - moves;
    }

    public TicTacType checkForWinner() {
        TicTacType winner = TicTacType.UNSELECTED;

        // 5 is the minimum number of moves anyway
        if (this.moves > 4) {


        }

        return winner;
    }
}
