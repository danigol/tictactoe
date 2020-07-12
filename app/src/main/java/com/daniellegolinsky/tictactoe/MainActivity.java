package com.daniellegolinsky.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daniellegolinsky.tictactoe.ToeCell.TicTacType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ToeBoard mTicTacToeBoard;

    private List<Button> gridButtons;
    private Button mNewGame;

    private TextView mScore;
    private int mXScore = 0;
    private int mOScore = 0;

    private Button mResetScore;

    private TicTacType mTurn = TicTacType.X;
    private TicTacType mWinner = TicTacType.UNSELECTED;

    private static Toast mToast;

    private boolean mSomeoneWon = false;

    private TextView mDirections;

    private boolean mGaveDirections;

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

        mDirections = (TextView) findViewById(R.id.directions);

        gridButtons = new ArrayList<>();
        for (int i = 0; i < mTicTacToeBoard.boardSize(); i++) {
            // Only made for 9, for now
            Button b;
            switch(i) {
                case 0:
                    b = findViewById(R.id.one_one);
                    b.setOnClickListener(v -> {
                        if (mTicTacToeBoard.get(0).getCurrentValue() == TicTacType.UNSELECTED) {
                            tapCell(0);
                        } else {
                            toast(Toast.makeText(this,
                                    "Please pick another cell.",
                                    Toast.LENGTH_SHORT));
                        }
                    });
                    gridButtons.add(b);
                    break;
                case 1:
                    b = findViewById(R.id.one_two);
                    b.setOnClickListener(v -> {
                        if (mTicTacToeBoard.get(1).getCurrentValue() == TicTacType.UNSELECTED) {
                            tapCell(1);
                        } else {
                            toast(Toast.makeText(this,
                                    "Please pick another cell.",
                                    Toast.LENGTH_SHORT));
                        }
                    });
                    gridButtons.add(b);
                    break;
                case 2:
                    b = findViewById(R.id.one_three);
                    b.setOnClickListener(v -> {
                        if (mTicTacToeBoard.get(2).getCurrentValue() == TicTacType.UNSELECTED) {
                            tapCell(2);
                        } else {
                            toast(Toast.makeText(this,
                                    "Please pick another cell.",
                                    Toast.LENGTH_SHORT));
                        }
                    });
                    gridButtons.add(b);
                    break;
                case 3:
                    b = findViewById(R.id.two_one);
                    b.setOnClickListener(v -> {
                        if (mTicTacToeBoard.get(3).getCurrentValue() == TicTacType.UNSELECTED) {
                            tapCell(3);
                        } else {
                            toast(Toast.makeText(this,
                                    "Please pick another cell.",
                                    Toast.LENGTH_SHORT));
                        }
                    });
                    gridButtons.add(b);
                    break;
                case 4:
                    b = findViewById(R.id.two_two);
                    b.setOnClickListener(v -> {
                        if (mTicTacToeBoard.get(4).getCurrentValue() == TicTacType.UNSELECTED) {
                            tapCell(4);
                        } else {
                            toast(Toast.makeText(this,
                                    "Please pick another cell.",
                                    Toast.LENGTH_SHORT));
                        }
                    });
                    gridButtons.add(b);
                    break;
                case 5:
                    b = findViewById(R.id.two_three);
                    b.setOnClickListener(v -> {
                        if (mTicTacToeBoard.get(5).getCurrentValue() == TicTacType.UNSELECTED) {
                            tapCell(5);
                        } else {
                            toast(Toast.makeText(this,
                                    "Please pick another cell.",
                                    Toast.LENGTH_SHORT));
                        }
                    });
                    gridButtons.add(b);
                    break;
                case 6:
                    b = findViewById(R.id.three_one);
                    b.setOnClickListener(v -> {
                        if (mTicTacToeBoard.get(6).getCurrentValue() == TicTacType.UNSELECTED) {
                            tapCell(6);
                        } else {
                            toast(Toast.makeText(this,
                                    "Please pick another cell.",
                                    Toast.LENGTH_SHORT));
                        }
                    });
                    gridButtons.add(b);
                    break;
                case 7:
                    b = findViewById(R.id.three_two);
                    b.setOnClickListener(v -> {
                        if (mTicTacToeBoard.get(7).getCurrentValue() == TicTacType.UNSELECTED) {
                            tapCell(7);
                        } else {
                            toast(Toast.makeText(this,
                                    "Please pick another cell.",
                                    Toast.LENGTH_SHORT));
                        }
                    });
                    gridButtons.add(b);
                    break;
                case 8:
                    b = findViewById(R.id.three_three);
                    b.setOnClickListener(v -> {
                        if (mTicTacToeBoard.get(8).getCurrentValue() == TicTacType.UNSELECTED) {
                            tapCell(8);
                        } else {
                            toast(Toast.makeText(this,
                                    "Please pick another cell.",
                                    Toast.LENGTH_SHORT));
                        }
                    });
                    gridButtons.add(b);
                    break;
                }
            }

        updateBoard();
        mGaveDirections = true;
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

            Button b = gridButtons.get(i);
            if (type.equals(TicTacType.X)) {
                b.setTextColor(getResources().getColor(R.color.xTextColor));
            }
            else {
                b.setTextColor(getResources().getColor(R.color.oTextColor));
            }
            b.setText(type.toString());
        }

        mScore.setText(getString(R.string.score, mXScore, mOScore));

        // Display whose turn it is after the first move
        if (mGaveDirections) {
            mDirections.setText(getString(R.string.whose_turn, mTurn.toString()));
        }
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
