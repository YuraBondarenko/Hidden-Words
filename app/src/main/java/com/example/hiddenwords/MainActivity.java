package com.example.hiddenwords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Arrays;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.hiddenwords.utils.ButtonUtils;
import com.example.hiddenwords.model.User;
import com.example.hiddenwords.utils.Checker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText login;
    private EditText password;
    private TextView error;
    private Button log_in_button;
    private Button sing_up_button;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        error = findViewById(R.id.error);
        log_in_button = findViewById(R.id.log_in);
        sing_up_button = findViewById(R.id.sing_up);
        auth = FirebaseAuth.getInstance();

        log_in_button.setOnClickListener(this);
        sing_up_button.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            startActivity(new Intent(MainActivity.this, LevelsActivity.class));
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.log_in) {
            String login = this.login.getText().toString();
            String password = this.password.getText().toString();
            if (Checker.checkLogin(login)) {
                error.setText(R.string.incorrect_login);
            } else if (Checker.checkPassword(password)) {
                error.setText(R.string.incorrect_password);
            } else {
                auth.signInWithEmailAndPassword(login, password).addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(MainActivity.this, LevelsActivity.class));
                    } else {
                        error.setText(R.string.sing_in_error);
                    }
                });
            }
        } else if (view.getId() == R.id.sing_up) {
            startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
        }
    }
}