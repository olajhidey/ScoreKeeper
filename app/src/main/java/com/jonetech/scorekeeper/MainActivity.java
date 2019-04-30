package com.jonetech.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member variable for holding the score
    private int fScore1;
    private int fScore2;

    // Member variable to the Textviews
    private TextView fScoreText1;
    private TextView fScoreText2;

    // Saved instance tags
    static final String SCORE_TEAM_ONE = "score team one";

    static final String SCORE_TEAM_TWO = "score team two";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fScoreText1 = findViewById(R.id.score_team1);
        fScoreText2 = findViewById(R.id.score_team2);

        if (savedInstanceState != null) {
            loadSavedInstance(savedInstanceState);
        }

    }

    private void loadSavedInstance(Bundle savedInstance) {
        String score1 = String.valueOf(savedInstance.getInt(SCORE_TEAM_ONE));
        String score2 = String.valueOf(savedInstance.getInt(SCORE_TEAM_TWO));

        fScoreText1.setText(score1);
        fScoreText2.setText(score2);
    }

    /**
     * Click event to handle score decrement from both
     * we're going to be using the View to get the difference
     * between both team
     *
     * @param view
     */

    public void decreaseScore(View view) {

        // Step 1: Get the ID of the button that was clicked
        int id = view.getId();

        // Step 2: Use the switch statement to detect the correct button
        switch (id) {

            // Check if it was team1
            case R.id.decreaseTeam1:

                // decrement the score of team1
                fScore1--;
                fScoreText1.setText(String.valueOf(fScore1));
                break;

            // Check if it was team 2
            case R.id.decreaseTeam2:

                // decrement the score of team2
                fScore2--;
                fScoreText2.setText(String.valueOf(fScore2)); // set current value on textview to current fScore2 value

        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt(SCORE_TEAM_ONE, fScore1);
        outState.putInt(SCORE_TEAM_TWO, fScore2);

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_item) {

            int nightMode = AppCompatDelegate.getDefaultNightMode();

            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
            }

            // Recreate the activity for the theme to make effect
            recreate();
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.menu_item).setTitle(getString(R.string.day_mode));
        } else {
            menu.findItem(R.id.menu_item).setTitle(getString(R.string.night_mode));
        }

        return true;
    }

    /**
     * Click event to handle score increment from both
     * we're going to be using the View to get the difference
     * between both team
     *
     * @param view
     */

    public void increaseScore(View view) {

        // So we would be performing the same step as we did in the decreaseScore function

        // Get view id
        int id = view.getId();

        switch (id) {

            case R.id.increaseTeam1:
                fScore1++;
                fScoreText1.setText(String.valueOf(fScore1));
                break;

            case R.id.increaseTeam2:
                fScore2++;
                fScoreText2.setText(String.valueOf(fScore2));

        }

    }
}
