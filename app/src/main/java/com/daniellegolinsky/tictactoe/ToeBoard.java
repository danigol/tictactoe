package com.daniellegolinsky.tictactoe;

import java.util.ArrayList;
import java.util.List;

import com.daniellegolinsky.tictactoe.ToeCell.TicTacType;

/**
 * Created by Danielle on 12/2/18.
 */

public class ToeBoard {

    private static final int TOTAL_MOVES = 9;
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;

    private int moves = 0;
    private List<ToeCell> cells;

    private static ToeBoard instance;

    public static ToeBoard instance() {
        if (instance == null) {
            return new ToeBoard();
        }
        return instance;
    }

    private ToeBoard() {
        cells = new ArrayList<>();
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

    public void resetBoard() {
        this.moves = 0;
    }

    public TicTacType checkForWinner() {
        // 5 is the minimum number of moves anyway
        if (this.moves > 4) {
            TicTacType rows = checkRows();
            if (!rows.equals(TicTacType.UNSELECTED)) {
                return rows;
            }

            TicTacType columns = checkColumns();
            if (!columns.equals(TicTacType.UNSELECTED)) {
                return columns;
            }

            TicTacType diagonally = checkDiagonally();
            if (!diagonally.equals(TicTacType.UNSELECTED)) {
                return diagonally;
            }
        }

        return TicTacType.UNSELECTED;
    }

    private TicTacType checkRows() {
        TicTacType winner = TicTacType.UNSELECTED;
        TicTacType cell;
        for (int y = 0; y < cells.size(); y += HEIGHT) {
            cell = this.cells.get(y).getCurrentValue();
            if (cell.equals(TicTacType.UNSELECTED)) {
                continue;
            }
            TicTacType nextCell = this.cells.get(y + 1).getCurrentValue();
            TicTacType lastCell = this.cells.get(y + 2).getCurrentValue();

            if (cell.equals(nextCell) && cell.equals(lastCell)) {
                winner = cell;
                break;
            }
        }

        return winner;
    }

    private TicTacType checkColumns() {
        TicTacType winner = TicTacType.UNSELECTED;
        TicTacType cell;
        for (int x = 0; x < WIDTH; x++) {
            cell = this.cells.get(x).getCurrentValue();
            if (cell.equals(TicTacType.UNSELECTED)) {
                continue;
            }
            TicTacType nextCell = this.cells.get(x + WIDTH).getCurrentValue();
            TicTacType lastCell = this.cells.get(x + (WIDTH * 2)).getCurrentValue();

            if (cell.equals(nextCell) && cell.equals(lastCell)) {
                winner = cell;
                break;
            }
        }

        return winner;
    }

    private TicTacType checkDiagonally() {

        TicTacType topLeft = this.cells.get(0).getCurrentValue();
        TicTacType center = this.cells.get(4).getCurrentValue(); // TODO Oh, I don't like constants like this.
        TicTacType topRight = this.cells.get(WIDTH - 1).getCurrentValue();
        TicTacType bottomLeft = this.cells.get(6).getCurrentValue();
        TicTacType bottomRight = this.cells.get(8).getCurrentValue();

        if (topLeft.equals(center) && topLeft.equals(bottomRight)) {
            return topLeft;
        }

        if (topRight.equals(center) && topRight.equals(bottomLeft)) {
            return topRight;
        }

        return TicTacType.UNSELECTED;
    }
}
