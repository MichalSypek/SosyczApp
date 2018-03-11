package com.sypcio.sosyczapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Memes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memes);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
