package com.daniellegolinsky.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daniellegolinsky.tictactoe.ToeCell.TicTacType;

public class MainActivity extends AppCompatActivity {

    private ToeBoard mTicTacToeBoard;

    private Button mOneOne;
    private Button mOneTwo;
    private Button mOneThree;
    private Button mTwoOne;
    private Button mTwoTwo;
    private Button mTwoThree;
    private Button mThreeOne;
    private Button mThreeTwo;
    private Button mThreeThree;

    private Button mNewGame;

    private TextView mScore;
    private int mXScore = 0;
    private int mOScore = 0;

    private Button mResetScore;

    private TicTacType mTurn = TicTacType.X;
    private TicTacType mWinner = TicTacType.UNSELECTED;

    private static Toast mToast;

    private boolean mSomeoneWon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTicTacToeBoard = ToeBoard.instance();

        mScore = (TextView) findViewById(R.id.score);

        mNewGame = (Button) findViewById(R.id.new_game_button);
        mNewGame.setOnClickListener(v -> newGame());

        mResetScore = (Button) findViewById(R.id.reset_score_button);
        mResetScore.setOnClickListener(v -> resetScore());

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


        updateBoard();
    }

    private void tapCell(int i) {
        // Someone has not won yet or the game has tied
        if (!mSomeoneWon) {
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
                mSomeoneWon = true;

                if (mWinner.equals(TicTacType.X)) {
                    mXScore++;
                }
                else {
                    mOScore++;
                }
                updateBoard();
            }
            else if (mTicTacToeBoard.getMovesRemaining() == 0) {
                toast(Toast.makeText(this.getApplicationContext(),
                        "TIE!",
                        Toast.LENGTH_LONG));
            }
        }
        else {
            mToast.cancel();
            toast(Toast.makeText(this.getApplicationContext(),
                    "Start a new game, " + mWinner.toString() + " already won!",
                    Toast.LENGTH_LONG));
        }
    }

    /**
     * Update the board and score information
     */
    private void updateBoard() {
        // Update the letters, add a splash of color
        for (int i = 0; i < 9; i++) {
            TicTacType type = mTicTacToeBoard.get(i).getCurrentValue();

            switch(i) {
                case 0:
                    if (type.equals(TicTacType.X)) {
                        mOneOne.setTextColor(Color.parseColor("#aa0000"));
                    }
                    else {
                        mOneOne.setTextColor(Color.parseColor("#000000"));
                    }
                    mOneOne.setText(type.toString());
                    break;
                case 1:
                    if (type.equals(TicTacType.X)) {
                        mOneTwo.setTextColor(Color.parseColor("#aa0000"));
                    }
                    else {
                        mOneTwo.setTextColor(Color.parseColor("#000000"));
                    }
                    mOneTwo.setText(type.toString());
                    break;
                case 2:
                    if (type.equals(TicTacType.X)) {
                        mOneThree.setTextColor(Color.parseColor("#aa0000"));
                    }
                    else {
                        mOneThree.setTextColor(Color.parseColor("#000000"));
                    }
                    mOneThree.setText(type.toString());
                    break;
                case 3:
                    if (type.equals(TicTacType.X)) {
                        mTwoOne.setTextColor(Color.parseColor("#aa0000"));
                    }
                    else {
                        mTwoOne.setTextColor(Color.parseColor("#000000"));
                    }
                    mTwoOne.setText(type.toString());
                    break;
                case 4:
                    if (type.equals(TicTacType.X)) {
                        mTwoTwo.setTextColor(Color.parseColor("#aa0000"));
                    }
                    else {
                        mTwoTwo.setTextColor(Color.parseColor("#000000"));
                    }
                    mTwoTwo.setText(type.toString());
                    break;
                case 5:
                    if (type.equals(TicTacType.X)) {
                        mTwoThree.setTextColor(Color.parseColor("#aa0000"));
                    }
                    else {
                        mTwoThree.setTextColor(Color.parseColor("#000000"));
                    }
                    mTwoThree.setText(type.toString());
                    break;
                case 6:
                    if (type.equals(TicTacType.X)) {
                        mThreeOne.setTextColor(Color.parseColor("#aa0000"));
                    }
                    else {
                        mThreeOne.setTextColor(Color.parseColor("#000000"));
                    }
                    mThreeOne.setText(type.toString());
                    break;
                case 7:
                    if (type.equals(TicTacType.X)) {
                        mThreeTwo.setTextColor(Color.parseColor("#aa0000"));
                    }
                    else {
                        mThreeTwo.setTextColor(Color.parseColor("#000000"));
                    }
                    mThreeTwo.setText(type.toString());
                    break;
                case 8:
                    if (type.equals(TicTacType.X)) {
                        mThreeThree.setTextColor(Color.parseColor("#aa0000"));
                    }
                    else {
                        mThreeThree.setTextColor(Color.parseColor("#000000"));
                    }
                    mThreeThree.setText(type.toString());
                    break;
            }
        }

        mScore.setText(getString(R.string.score, mXScore, mOScore));
    }

    /**
     * Creates a new game, does not reset score
     */
    private void newGame() {
        for (int i = 0; i < 9; i++) {
            mTicTacToeBoard.get(i).setCurrentValue(TicTacType.UNSELECTED);
        }
        mSomeoneWon = false;
        mWinner = TicTacType.UNSELECTED;

        updateBoard();

        if (mToast != null) {
            mToast.cancel();
        }

        mTicTacToeBoard.resetBoard();
    }

    /**
     * Resets the score, does not start a new game
     */
    private void resetScore() {
        mXScore = 0;
        mOScore = 0;
        updateBoard();
    }

    private void toast(Toast t) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = t;
        mToast.show();
    }
}
