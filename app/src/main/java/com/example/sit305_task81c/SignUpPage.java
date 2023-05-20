package com.example.sit305_task81c;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpPage extends AppCompatActivity {
    EditText fullName, userName, password,confirmPassword;
    Button createAccount, backToHomePage;

    String fullNameInput, userNameInput,passwordInput,confirmPasswordInput;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        //Always write the references below the super or setContentView
        fullName = findViewById(R.id.fullNameEditText);
        userName = findViewById(R.id.userNameEditText);
        password = findViewById(R.id.passwordEditText);
        confirmPassword = findViewById(R.id.confirmPasswordEditText);
        backToHomePage = findViewById(R.id.backToHomePageBtn);

        createAccount = findViewById(R.id.createAccountBtn);

        // create a new firebase instance
        mAuth = FirebaseAuth.getInstance();

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add input to the firebase and print success message

                // get the value of user input
                fullNameInput = String.valueOf(fullName.getText());
                userNameInput = String.valueOf(userName.getText());
                passwordInput = String.valueOf(password.getText());
                confirmPasswordInput = String.valueOf(confirmPassword.getText());

                if (TextUtils.isEmpty(fullNameInput)
                        || TextUtils.isEmpty(userNameInput)
                        || TextUtils.isEmpty(passwordInput)
                        || TextUtils.isEmpty(confirmPasswordInput)){
                    //Check if the users input is empty, if they are empty , we display an error message
                    Toast.makeText(SignUpPage.this,
                            "Please enter a valid input..", Toast.LENGTH_SHORT).show();
                }

                // Create a new user instance based on their input which are the email and password
                mAuth.createUserWithEmailAndPassword(userNameInput, passwordInput)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    Toast.makeText(SignUpPage.this,
                                            "Sign up succeeded.", Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SignUpPage.this,
                                            "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        backToHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpPage.this,MainActivity.class));
            }
        });
    }
}