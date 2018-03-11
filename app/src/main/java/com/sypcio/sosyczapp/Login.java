package com.sypcio.sosyczapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import bolts.Task;


public class Login extends AppCompatActivity  {

    private TextView info,inputEmail, inputPassword;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private FirebaseAuth mAuth;
    private FirebaseAuth auth;
    private Button notRegistered;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //---------------Przejście do ekranu rejestracji-------------
        notRegistered =(Button) findViewById(R.id.not_rgst_btn);
        notRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
        //----------------------------------------------------------



        //--------------------Facebook------------------------------------
        FacebookSdk.sdkInitialize(getApplicationContext());  //uwierzytelnianie Facebook
        callbackManager = CallbackManager.Factory.create();
        info = (TextView) findViewById(R.id.info);
        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() { //odpowiada za wyświetlanie okna logowania FB
            @Override
            public void onSuccess(LoginResult loginResult) {
                setContentView(R.layout.activity_menu);  //wyświetla po udanym uwierzytelnianiu Fejsa

                /**
                private void handleFacebookAccessToken(AccessToken token) {

                    AuthCredential credential = FacebookAuthProvider.getCredential(com.facebook.AccessToken.getCurrentAccessToken());
                    mAuth.signInWithCredential(credential)
                            .addOnCompleteListener(this, new com.google.android.gms.tasks.OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information

                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(Login.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }

                                    // ...
                                }
                            });
                }**/

            }

            @Override
            public void onCancel() {
                info.setText("Process anulled");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Process failed");
            }
        });
        //---------------------------------------------------------------


        //-----------------Uwierzytelnianie Firebase---------------------
        auth = FirebaseAuth.getInstance();


        if (auth.getCurrentUser() != null) {                          //sprawdzenie czy użytkownik nie jest zalogowany
            startActivity(new Intent(this, Menu.class));
            finish();
        }


        Button btnLogin = findViewById(R.id.loginbtn);
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.pass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new com.google.android.gms.tasks.OnCompleteListener<AuthResult>() {


                            @Override
                            public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(Login.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    finish();
                                    Intent intent = new Intent(Login.this, Menu.class);
                                    startActivity(intent);
                                    //finish();
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}