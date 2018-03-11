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
