package com.example.aliceresponde.golfscore;

public class Hole {
    private String label ;
    private int scoreValue;

    public Hole(String label, int scoreValue) {
        this.label = label;
        this.scoreValue = scoreValue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }
}
