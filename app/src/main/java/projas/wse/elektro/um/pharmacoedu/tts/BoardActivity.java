package projas.wse.elektro.um.pharmacoedu.tts;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.tts.fragment.PuzzleFiveFragment;
import projas.wse.elektro.um.pharmacoedu.tts.fragment.PuzzleFourFragment;
import projas.wse.elektro.um.pharmacoedu.tts.fragment.PuzzleOneFragment;
import projas.wse.elektro.um.pharmacoedu.tts.fragment.PuzzleSevenFragment;
import projas.wse.elektro.um.pharmacoedu.tts.fragment.PuzzleSixFragment;
import projas.wse.elektro.um.pharmacoedu.tts.fragment.PuzzleThreeFragment;
import projas.wse.elektro.um.pharmacoedu.tts.fragment.PuzzleTwoFragment;

public class BoardActivity extends AppCompatActivity {

    private final String PUZZLE_ONE = "one", PUZZLE_TWO = "two",
            PUZZLE_THREE = "three", PUZZLE_FOUR = "four",
            PUZZLE_FIVE = "five", PUZZLE_SIX = "six", PUZZLE_SEVEN = "seven";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        int level = getIntent().getIntExtra("pos", 0);

        TextView tvTitle = (TextView) findViewById(R.id.board_tv_title);
        tvTitle.setText(String.format(getString(R.string.title_board), (level+1)));

        switch (level) {
            case 0:
                showFragment(PUZZLE_ONE);
                break;
            case 1:
                showFragment(PUZZLE_TWO);
                break;
            case 2:
                showFragment(PUZZLE_THREE);
                break;
            case 3:
                showFragment(PUZZLE_FOUR);
                break;
            case 4:
                showFragment(PUZZLE_FIVE);
                break;
            case 5:
                showFragment(PUZZLE_SIX);
                break;
            case 6:
                showFragment(PUZZLE_SEVEN);
                break;
            case 7:
                showFragment(PUZZLE_ONE);
                break;
            default:
                break;
        }
    }

    private void showFragment(String fragmentTag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        if (fragment == null) {
            switch (fragmentTag) {
                case PUZZLE_ONE:
                    fragment = new PuzzleOneFragment();
                    break;
                case PUZZLE_TWO:
                    fragment = new PuzzleTwoFragment();
                    break;
                case PUZZLE_THREE:
                    fragment = new PuzzleThreeFragment();
                    break;
                case PUZZLE_FOUR:
                    fragment = new PuzzleFourFragment();
                    break;
                case PUZZLE_FIVE:
                    fragment = new PuzzleFiveFragment();
                    break;
                case PUZZLE_SIX:
                    fragment = new PuzzleSixFragment();
                    break;
                case PUZZLE_SEVEN:
                    fragment = new PuzzleSevenFragment();
                    break;
                default:
                    return;
            }
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.board_fragment_container, fragment, fragmentTag)
                .commit();
    }
}
