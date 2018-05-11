package com.example.aliceresponde.golfscore;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {
    private Hole[] mHoles = new Hole[18];
    private HoleAdapter mHoleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillHoles();
        mHoleAdapter = new HoleAdapter(mHoles, this);
        setListAdapter(mHoleAdapter);
    }

    private void fillHoles() {
        for (int i = 0; i < mHoles.length; i++) {
            mHoles[i] = new Hole("Hole " + (i + 1) + " :", 0);
        }
    }
}
