package com.example.hiddenwords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    //   private final RegistrationActivity registrationActivity;

    private final String regex = "^(.+)@(.+)$";
    private final Pattern pattern = Pattern.compile(regex);

    private EditText login;
    private EditText password;
    private TextView error;
    private Button log_in_button;
    private Button sing_up_button;
    private ProgressBar progressBar;

 /*   public MainActivity(RegistrationActivity registrationActivity) {
        this.registrationActivity = registrationActivity;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        error = findViewById(R.id.error);
        log_in_button = findViewById(R.id.log_in);
        sing_up_button = findViewById(R.id.sing_up);
        // progressBar = findViewById(R.id.progressBar);

        log_in_button.setOnClickListener(v -> {
            ButtonUtils.setButtonsEnableOrDisabled(Arrays.asList(log_in_button, sing_up_button), false);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String login = this.login.getText().toString();
            String password = this.password.getText().toString();
            Matcher matcher = pattern.matcher(login);
            if (!matcher.matches()) {
                error.setText(R.string.incorrect_login);
            } else if (password == null || password.length() < 8) {
                error.setText(R.string.incorrect_password);
            } else {
                User user = new User(login, password);
                //  setContentView(R.layout.activity_login);
            }
            ButtonUtils.setButtonsEnableOrDisabled(Arrays.asList(log_in_button, sing_up_button), true);
        });

        // sing_up_button.setOnClickListener(v -> setContentView(R.layout.activity_registration));

    }


}