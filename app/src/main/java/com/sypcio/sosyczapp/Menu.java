package com.sypcio.sosyczapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Button memy = findViewById(R.id.memy);
        memy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMemy();
            }
        });

        final Button pasty = findViewById(R.id.pasty);
        pasty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openPasty();
            }
        });

        final Button kalkulator = findViewById(R.id.kalkulator);
        kalkulator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openKalkulator();
            }
        });

        final Button cytaty = findViewById(R.id.cytaty);
        cytaty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCytaty();
            }
        });

        final Button terminarz = findViewById(R.id.terminarz);
        terminarz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTerminarz();
            }
        });

    }

    public void openMemy(){
        Intent intent = new Intent(this, Memy.class);
        startActivity(intent);
    }

    public void openPasty(){
        Intent intent = new Intent(this, Pasty.class);
        startActivity(intent);
    }

    public void openKalkulator(){
        Intent intent = new Intent(this, Kalkulator.class);
        startActivity(intent);
    }

    public void openCytaty(){
        Intent intent = new Intent(this, Cytaty.class);
        startActivity(intent);
    }

    public void openTerminarz(){
        Intent intent = new Intent(this, Terminarz.class);
        startActivity(intent);
    }
}
