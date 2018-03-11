package com.sypcio.sosyczapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Quotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
