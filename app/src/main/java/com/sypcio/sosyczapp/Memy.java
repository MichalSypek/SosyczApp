package com.sypcio.sosyczapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Memy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memy);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
