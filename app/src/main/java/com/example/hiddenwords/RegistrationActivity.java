package com.example.hiddenwords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiddenwords.utils.Checker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {
    private Button sing_up_button;
    private EditText login;
    private EditText password;
    private TextView error;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        sing_up_button = findViewById(R.id.sing_up);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        error = findViewById(R.id.error);
        auth = FirebaseAuth.getInstance();


        sing_up_button.setOnClickListener(s -> {
            String login = this.login.getText().toString();
            String password = this.password.getText().toString();
            if (Checker.checkLogin(login)) {
                error.setText(R.string.incorrect_login);
            } else if (Checker.checkPassword(password)) {
                error.setText(R.string.incorrect_password);
            } else {
                auth.createUserWithEmailAndPassword(login, password).addOnCompleteListener(singUpTask -> {
                    if (singUpTask.isSuccessful()) {
                        auth.signInWithEmailAndPassword(login, password).addOnCompleteListener(loginTask -> {
                            if (loginTask.isSuccessful()) {
                                //startActivity(new Intent(RegistrationActivity.this, LevelsActivity.class));
                            } else {
                                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                            }
                        });
                    } else {
                        error.setText(R.string.sing_up_error);
                    }
                });
            }
        });
    }
}