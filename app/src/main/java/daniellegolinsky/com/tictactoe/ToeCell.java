package daniellegolinsky.com.tictactoe;

/**
 * Created by Danielle on 12/2/18.
 */

public class ToeCell {

    enum TicTacType {
        UNSELECTED(-1),
        X(0),
        O(1);

        int value;

        void next() {
            value++;
            value = value %2;
        }

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
    }

    public ToeCell(int p, TicTacType cv) {
        this.position = p;
        this.currentValue = cv;
    }

    public int getPosition() {
        return this.position;
    }

    public TicTacType getCurrentValue() {
        return this.currentValue;
    }

    public void setCurrentValue(TicTacType value) {
        this.currentValue = value;
    }
}
