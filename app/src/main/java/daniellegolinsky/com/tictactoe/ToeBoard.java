package daniellegolinsky.com.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danielle on 12/2/18.
 */

public class ToeBoard {

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
    }
}
