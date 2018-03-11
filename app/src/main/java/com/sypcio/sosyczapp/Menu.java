package com.sypcio.sosyczapp;



import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;


public class Menu extends AppCompatActivity {
private FirebaseAuth auth;
private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Button memes = findViewById(R.id.memy);
        memes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMemes();
            }
        });

        final Button pastas = findViewById(R.id.pasty);
        pastas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openPastas();
            }
        });

        final Button calculator = findViewById(R.id.kalkulator);
        calculator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCalculator();
            }
        });

        final Button quotes = findViewById(R.id.cytaty);
        quotes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openQuotes();
            }
        });

        final Button timetable = findViewById(R.id.terminarz);
        timetable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTimetable();
            }
        });

        ImageButton logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(Menu.this, Login.class);
                startActivity(intent);
            }
        });

    }

    public void openMemes(){
        Intent intent = new Intent(this, Memes.class);
        startActivity(intent);
    }

    public void openPastas(){
        Intent intent = new Intent(this, Pastas.class);
        startActivity(intent);
    }

    public void openCalculator(){
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }

    public void openQuotes(){
        Intent intent = new Intent(this, Quotes.class);
        startActivity(intent);
    }

    public void openTimetable(){
        Intent intent = new Intent(this, Timetable.class);
        startActivity(intent);
    }
}
