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

   TicTacType mTurn = TicTacType.X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTicTacToeBoard = new ToeBoard();

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
            if ("".equals(mOneOne.getText())) {
                mOneOne.setText(mTurn.toString());
                tapCell(0);
            }
            else {
                Toast.makeText(this, "Please pick another cell.", Toast.LENGTH_SHORT);
            }
        });

        mOneTwo.setOnClickListener(v -> {
            if ("".equals(mOneTwo.getText())) {
                mOneTwo.setText(mTurn.toString());
                tapCell(1);
            }
            else {
                Toast.makeText(this, "Please pick another cell.", Toast.LENGTH_SHORT);
            }
        });

        mOneThree.setOnClickListener(v -> {
            if ("".equals(mOneThree.getText())) {
                mOneThree.setText(mTurn.toString());
                tapCell(2);
            }
            else {
                Toast.makeText(this, "Please pick another cell.", Toast.LENGTH_SHORT);
            }
        });

        mTwoOne.setOnClickListener(v -> {
            if ("".equals(mTwoOne.getText())) {
                mTwoOne.setText(mTurn.toString());
                tapCell(3);
            }
            else {
                Toast.makeText(this, "Please pick another cell.", Toast.LENGTH_SHORT);
            }
        });

        mTwoTwo.setOnClickListener(v -> {
            if ("".equals(mTwoTwo.getText())) {
                mTwoTwo.setText(mTurn.toString());
                tapCell(4);
            }
            else {
                Toast.makeText(this, "Please pick another cell.", Toast.LENGTH_SHORT);
            }
        });

        mTwoThree.setOnClickListener(v -> {
            if ("".equals(mTwoThree.getText())) {
                mTwoThree.setText(mTurn.toString());
                tapCell(5);
            }
            else {
                Toast.makeText(this, "Please pick another cell.", Toast.LENGTH_SHORT);
            }
        });

        mThreeOne.setOnClickListener(v -> {
            if ("".equals(mThreeOne.getText())) {
                mThreeOne.setText(mTurn.toString());
                tapCell(6);
            }
            else {
                Toast.makeText(this, "Please pick another cell.", Toast.LENGTH_SHORT);
            }
        });

        mThreeTwo.setOnClickListener(v -> {
            if ("".equals(mThreeTwo.getText())) {
                mThreeTwo.setText(mTurn.toString());
                tapCell(7);
            }
            else {
                Toast.makeText(this, "Please pick another cell.", Toast.LENGTH_SHORT);
            }
        });

        mThreeThree.setOnClickListener(v -> {
            if ("".equals(mThreeThree.getText())) {
                mThreeThree.setText(mTurn.toString());
                tapCell(8);
            }
            else {
                Toast.makeText(this, "Please pick another cell.", Toast.LENGTH_SHORT);
            }
        });

    }

    public void tapCell(int i) {
        ToeCell tc = mTicTacToeBoard.get(i);
        tc.setCurrentValue(mTurn);
        mTurn.next();
    }
}
