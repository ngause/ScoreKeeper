package com.example.android.scorekeeper;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pointsTeamA = 0;
    int pointsTeamB = 0;
    String color_check;

    // spinner change image variables
    private String[] listOfObjects;
    private TypedArray images;
    private ImageView itemImageA;
    private ImageView itemImageB;
    // variables for changing button shape background
    private TypedArray team_colors;
    private Button team_a_td_color;
    private Button team_a_xp_color;
    private Button team_a_tpc_color;
    private Button team_a_fg_color;
    private Button team_a_saf_color;
    private Button team_b_td_color;
    private Button team_b_xp_color;
    private Button team_b_tpc_color;
    private Button team_b_fg_color;
    private Button team_b_saf_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(pointsTeamA);
        displayForTeamB(pointsTeamB);

        //change image with spinner

        listOfObjects = getResources().getStringArray(R.array.nfl_teams_array);
        images = getResources().obtainTypedArray(R.array.team_image);
        team_colors = getResources().obtainTypedArray(R.array.team_color_array);

        // Team A spinner

        itemImageA = (ImageView)findViewById(R.id.team_a_image);
        team_a_td_color = (Button)findViewById(R.id.team_a_td);
        team_a_xp_color = (Button)findViewById(R.id.team_a_xp);
        team_a_tpc_color = (Button)findViewById(R.id.team_a_tpc);
        team_a_fg_color = (Button)findViewById(R.id.team_a_fg);
        team_a_saf_color = (Button)findViewById(R.id.team_a_saf);
        final Spinner spinnerA = (Spinner)findViewById(R.id.team_a_spinner);
        ArrayAdapter<String> spinnerAdapterA = new ArrayAdapter<String>(this,R.layout.spinner_item, listOfObjects);
        spinnerAdapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(spinnerAdapterA);
        spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemImageA.setImageResource(images.getResourceId(spinnerA.getSelectedItemPosition(), -1));
                team_a_td_color.setBackgroundResource(team_colors.getResourceId(spinnerA.getSelectedItemPosition(),-1));
                team_a_xp_color.setBackgroundResource(team_colors.getResourceId(spinnerA.getSelectedItemPosition(),-1));
                team_a_tpc_color.setBackgroundResource(team_colors.getResourceId(spinnerA.getSelectedItemPosition(),-1));
                team_a_fg_color.setBackgroundResource(team_colors.getResourceId(spinnerA.getSelectedItemPosition(),-1));
                team_a_saf_color.setBackgroundResource(team_colors.getResourceId(spinnerA.getSelectedItemPosition(),-1));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Team B spinner
        itemImageB = (ImageView)findViewById(R.id.team_b_image);
        team_b_td_color = (Button)findViewById(R.id.team_b_td);
        team_b_xp_color = (Button)findViewById(R.id.team_b_xp);
        team_b_tpc_color = (Button)findViewById(R.id.team_b_tpc);
        team_b_fg_color = (Button)findViewById(R.id.team_b_fg);
        team_b_saf_color = (Button)findViewById(R.id.team_b_saf);
        final Spinner spinnerB = (Spinner)findViewById(R.id.team_b_spinner);
        ArrayAdapter<String> spinnerAdapterB = new ArrayAdapter<String>(this,R.layout.spinner_item, listOfObjects);
        spinnerAdapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerB.setAdapter(spinnerAdapterB);
        spinnerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemImageB.setImageResource(images.getResourceId(spinnerB.getSelectedItemPosition(), -1));
                team_b_td_color.setBackgroundResource(team_colors.getResourceId(spinnerB.getSelectedItemPosition(),-1));
                team_b_xp_color.setBackgroundResource(team_colors.getResourceId(spinnerB.getSelectedItemPosition(),-1));
                team_b_tpc_color.setBackgroundResource(team_colors.getResourceId(spinnerB.getSelectedItemPosition(),-1));
                team_b_fg_color.setBackgroundResource(team_colors.getResourceId(spinnerB.getSelectedItemPosition(),-1));
                team_b_saf_color.setBackgroundResource(team_colors.getResourceId(spinnerB.getSelectedItemPosition(),-1));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pointsTeamA", pointsTeamA);
        outState.putInt("pointsTeamB", pointsTeamB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pointsTeamA = savedInstanceState.getInt("pointsTeamA");
        pointsTeamB = savedInstanceState.getInt("pointsTeamB");
        displayForTeamA(pointsTeamA);
        displayForTeamB(pointsTeamB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        pointsTeamA = pointsTeamA + 1;
        displayForTeamA(pointsTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        pointsTeamA = pointsTeamA + 2;
        displayForTeamA(pointsTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        pointsTeamA = pointsTeamA +3;
        displayForTeamA(pointsTeamA);
    }

    /**
     * Increase the score for Team A by 6 points.
     */
    public void addSixForTeamA(View v) {
        pointsTeamA = pointsTeamA +6;
        displayForTeamA(pointsTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        pointsTeamB = pointsTeamB + 1;
        displayForTeamB(pointsTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        pointsTeamB = pointsTeamB + 2;
        displayForTeamB(pointsTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        pointsTeamB = pointsTeamB +3;
        displayForTeamB(pointsTeamB);
    }

    /**
     * Increase the score for Team B by 6 points.
     */
    public void addSixForTeamB(View v) {
        pointsTeamB = pointsTeamB +6;
        displayForTeamB(pointsTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Resets the given score for both teams to 0.
     */
    public void resetScore(View v) {
        pointsTeamA = 0;
        pointsTeamB = 0;
        displayForTeamA(pointsTeamA);
        displayForTeamB(pointsTeamB);
    }
}