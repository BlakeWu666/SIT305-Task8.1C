package com.example.sit305_task81c;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;
    Button signUp, login;

    FirebaseAuth mAuth;

    String userNameInput,passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = findViewById(R.id.signupBtn);
        login = findViewById(R.id.loginBtn);
        userName = findViewById(R.id.userNameEditText);
        password = findViewById(R.id.passwordEditText);

        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the value of user input
                userNameInput = String.valueOf(userName.getText());
                passwordInput = String.valueOf(password.getText());

                if(TextUtils.isEmpty(userNameInput) || TextUtils.isEmpty(passwordInput)){
                    //Check if the users input is empty, if they are empty , we display an error message
                    Toast.makeText(MainActivity.this,
                            "Please enter a valid input..", Toast.LENGTH_SHORT).show();
                }

                mAuth.signInWithEmailAndPassword(userNameInput , passwordInput)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    Toast.makeText(MainActivity.this, "Login successful.", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this,LoginPage.class));
                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                // if not print user does not exist
                    //Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpPage.class));
            }
        });
    }
}