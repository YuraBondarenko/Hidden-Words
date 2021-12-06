package com.example.hiddenwords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class ProfileActivity extends AppCompatActivity {
    private TextView email;
    private Button logout;
    private Button button_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logout = findViewById(R.id.logout);
        email = findViewById(R.id.email);
        button_switch = findViewById(R.id.button_switch);

        email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        logout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        });

        button_switch.setOnClickListener(view -> startActivity(new Intent(ProfileActivity.this, LevelsActivity.class)));
    }
}