package com.example.aliceresponde.golfscore;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {

    private static final String PREF_NAME = "com.example.aliceresponde.golfscore.pref";
    private static final String SCORE_KEY = "SCORE_KEY";

    private Hole[] mHoles = new Hole[18];
    private HoleAdapter mHoleAdapter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSharedPreferences();
        fillHoles();
        mHoleAdapter = new HoleAdapter(mHoles, this);
        setListAdapter(mHoleAdapter);
    }

    private void initSharedPreferences() {
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private void fillHoles() {
        int score = 0;
        for (int i = 0; i < mHoles.length; i++) {
            score = sharedPreferences.getInt(SCORE_KEY + i, 0);
            mHoles[i] = new Hole("Hole " + (i + 1) + " :", score);
        }
    }

    // Save on shared preferences
    @Override
    protected void onPause() {
        super.onPause();
        for (int i = 0; i < mHoles.length; i++) {
            editor.putInt(SCORE_KEY + i, mHoles[i].getScoreValue());
        }
        editor.apply();
    }
}
