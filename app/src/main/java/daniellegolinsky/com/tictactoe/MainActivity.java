package daniellegolinsky.com.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mOneOne;
    Button mOneTwo;
    Button mOneThree;
    Button mTwoOne;
    Button mTwoTwo;
    Button mTwoThree;
    Button mThreeOne;
    Button mThreeTwo;
    Button mThreeThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOneOne = (Button) findViewById(R.id.one_one);
        mOneTwo = (Button) findViewById(R.id.one_two);
        mOneThree = (Button) findViewById(R.id.one_three);
        mTwoOne = (Button) findViewById(R.id.two_one);
        mTwoTwo = (Button) findViewById(R.id.two_two);
        mTwoThree = (Button) findViewById(R.id.two_three);
        mThreeOne = (Button) findViewById(R.id.three_one);
        mThreeTwo = (Button) findViewById(R.id.three_two);
        mThreeThree= (Button) findViewById(R.id.three_three);
    }
}
