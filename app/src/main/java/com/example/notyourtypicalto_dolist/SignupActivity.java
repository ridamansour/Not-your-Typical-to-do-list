package com.example.notyourtypicalto_dolist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword,textView;
    FirebaseAuth mAuth;
    Button buttonReg;
    ProgressBar progressBar;
    EditText UserName;
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.signup_email);
        editTextPassword = findViewById(R.id.signup_password);
        buttonReg = findViewById(R.id.signup_button);
        progressBar = findViewById(R.id.signup_progressBar);
        textView = findViewById(R.id.loginRedirectText);
        UserName = findViewById(R.id.signup_name);
        progressBar = new ProgressBar(getApplicationContext());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email,password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(SignupActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(SignupActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(view.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Account created",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), UsersName.class);
                                    startActivity(intent);
                                    finish();
                                }

                                else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SignupActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });



    }

//    EditText signupName, signupEmail, signupUsername, signupPassword;
//    TextView loginRedirectText;
//    Button signupButton;
//    FirebaseDatabase database;
//    DatabaseReference reference;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signup);
//
//        signupName = findViewById(R.id.signup_name);
//        signupEmail = findViewById(R.id.signup_email);
//        signupUsername = findViewById(R.id.signup_username);
//        signupPassword = findViewById(R.id.signup_password);
//        signupButton = findViewById(R.id.signup_button);
//        loginRedirectText = findViewById(R.id.loginRedirectText);
//
//        signupButton.setOnClickListener(view -> {
//
//            database = FirebaseDatabase.getInstance();
//            reference = database.getReference("users");
//
//            String name = signupName.getText().toString();
//            String email = signupEmail.getText().toString();
//            String username = signupUsername.getText().toString();
//            String password = signupPassword.getText().toString();
//
//            HelperClass helperClass = new HelperClass(name, email, username, password);
//            reference.child(name).setValue(helperClass);
//
//            Toast.makeText(SignupActivity.this,"You have Sign Up successfully!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
//            startActivity(intent);
//
//        });
//
//        loginRedirectText.setOnClickListener(view -> {
//            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
//            startActivity(intent);
//        });
//
//    }
}