package daniellegolinsky.com.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import daniellegolinsky.com.tictactoe.ToeCell.TicTacType;

public class MainActivity extends AppCompatActivity {

    ToeBoard mTicTacToeBoard;

    Button mOneOne;
    Button mOneTwo;
    Button mOneThree;
    Button mTwoOne;
    Button mTwoTwo;
    Button mTwoThree;
    Button mThreeOne;
    Button mThreeTwo;
    Button mThreeThree;

    Button mNewGame;

    TicTacType mTurn = TicTacType.X;
    TicTacType mWinner = TicTacType.UNSELECTED;

    Toast message;

    boolean someoneWon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTicTacToeBoard = new ToeBoard();

        mNewGame = (Button) findViewById(R.id.new_game_button);
        mNewGame.setOnClickListener(v -> newGame());

        mOneOne = (Button) findViewById(R.id.one_one);
        mOneTwo = (Button) findViewById(R.id.one_two);
        mOneThree = (Button) findViewById(R.id.one_three);
        mTwoOne = (Button) findViewById(R.id.two_one);
        mTwoTwo = (Button) findViewById(R.id.two_two);
        mTwoThree = (Button) findViewById(R.id.two_three);
        mThreeOne = (Button) findViewById(R.id.three_one);
        mThreeTwo = (Button) findViewById(R.id.three_two);
        mThreeThree= (Button) findViewById(R.id.three_three);

        mOneOne.setOnClickListener(v -> {
            if (mTicTacToeBoard.get(0).getCurrentValue() == TicTacType.UNSELECTED) {
                tapCell(0);
            }
            else {
                toast(Toast.makeText(this,
                        "Please pick another cell.",
                        Toast.LENGTH_SHORT));
            }
        });

        mOneTwo.setOnClickListener(v -> {
            if (mTicTacToeBoard.get(1).getCurrentValue() == TicTacType.UNSELECTED) {
                tapCell(1);
            }
            else {
                toast(Toast.makeText(this,
                        "Please pick another cell.",
                        Toast.LENGTH_SHORT));
            }
        });

        mOneThree.setOnClickListener(v -> {
            if (mTicTacToeBoard.get(2).getCurrentValue() == TicTacType.UNSELECTED) {
                tapCell(2);
            }
            else {
                toast(Toast.makeText(this,
                        "Please pick another cell.",
                        Toast.LENGTH_SHORT));
            }
        });

        mTwoOne.setOnClickListener(v -> {
            if (mTicTacToeBoard.get(3).getCurrentValue() == TicTacType.UNSELECTED) {
                tapCell(3);
            }
            else {
                toast(Toast.makeText(this,
                        "Please pick another cell.",
                        Toast.LENGTH_SHORT));
            }
        });

        mTwoTwo.setOnClickListener(v -> {
            if (mTicTacToeBoard.get(4).getCurrentValue() == TicTacType.UNSELECTED) {
                tapCell(4);
            }
            else {
                toast(Toast.makeText(this,
                        "Please pick another cell.",
                        Toast.LENGTH_SHORT));
            }
        });

        mTwoThree.setOnClickListener(v -> {
            if (mTicTacToeBoard.get(5).getCurrentValue() == TicTacType.UNSELECTED) {
                tapCell(5);
            }
            else {
                toast(Toast.makeText(this,
                        "Please pick another cell.",
                        Toast.LENGTH_SHORT));
            }
        });

        mThreeOne.setOnClickListener(v -> {
            if (mTicTacToeBoard.get(6).getCurrentValue() == TicTacType.UNSELECTED) {
                tapCell(6);
            }
            else {
                toast(Toast.makeText(this,
                        "Please pick another cell.",
                        Toast.LENGTH_SHORT));
            }
        });

        mThreeTwo.setOnClickListener(v -> {
            if (mTicTacToeBoard.get(7).getCurrentValue() == TicTacType.UNSELECTED) {
                tapCell(7);
            }
            else {
                toast(Toast.makeText(this,
                        "Please pick another cell.",
                        Toast.LENGTH_SHORT));
            }
        });

        mThreeThree.setOnClickListener(v -> {
            if (mTicTacToeBoard.get(8).getCurrentValue() == TicTacType.UNSELECTED) {
                tapCell(8);
            }
            else {
                toast(Toast.makeText(this,
                        "Please pick another cell.",
                        Toast.LENGTH_SHORT));
            }
        });
    }

    public void tapCell(int i) {
        if (!someoneWon) {
            mTicTacToeBoard.set(i, mTurn);

            if (mTurn.equals(TicTacType.X)) {
                mTurn = TicTacType.O;
            } else {
                mTurn = TicTacType.X;
            }

            // Update GUI
            updateBoard();

            // Check for a winner
            mWinner = mTicTacToeBoard.checkForWinner();
            if (!mWinner.equals(TicTacType.UNSELECTED)) {
               toast(Toast.makeText(this.getApplicationContext(),
                        mWinner.toString() + " wins!",
                        Toast.LENGTH_LONG));
                someoneWon = true;
            }
        }
        else {
            message.cancel();
            toast(Toast.makeText(this.getApplicationContext(),
                    "Start a new game, " + mWinner.toString() + " already won!",
                    Toast.LENGTH_LONG));
        }
    }

    public void updateBoard() {
        mOneOne.setText(mTicTacToeBoard.get(0).getCurrentValue().toString());
        mOneTwo.setText(mTicTacToeBoard.get(1).getCurrentValue().toString());
        mOneThree.setText(mTicTacToeBoard.get(2).getCurrentValue().toString());
        mTwoOne.setText(mTicTacToeBoard.get(3).getCurrentValue().toString());
        mTwoTwo.setText(mTicTacToeBoard.get(4).getCurrentValue().toString());
        mTwoThree.setText(mTicTacToeBoard.get(5).getCurrentValue().toString());
        mThreeOne.setText(mTicTacToeBoard.get(6).getCurrentValue().toString());
        mThreeTwo.setText(mTicTacToeBoard.get(7).getCurrentValue().toString());
        mThreeThree.setText(mTicTacToeBoard.get(8).getCurrentValue().toString());
    }

    public void newGame() {
        for (int i = 0; i < 9; i++) {
            mTicTacToeBoard.get(i).setCurrentValue(TicTacType.UNSELECTED);
        }
        someoneWon = false;
        mWinner = TicTacType.UNSELECTED;
        updateBoard();

        if (message != null) {
            message.cancel();
        }
    }

    public void toast(Toast t) {
        if (message != null) {
            message = null;
        }
        message = t;
        message.show();
    }
}
