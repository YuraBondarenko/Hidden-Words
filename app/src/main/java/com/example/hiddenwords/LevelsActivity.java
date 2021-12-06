package com.example.hiddenwords;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.hiddenwords.model.User;
import com.example.hiddenwords.model.UserLevel;
import com.example.hiddenwords.repo.UserLevelRepo;
import com.example.hiddenwords.service.UserLevelService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LevelsActivity extends AppCompatActivity implements View.OnClickListener {
    private UserLevelService userLevelService;

    private Button level1;
    private Button level2;
    private Button level3;
    private Button level4;
    private Button level5;
    private Button level6;
    private Button level7;
    private Button level8;
    private Button level9;
    private Button switch_button;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        userLevelService = new UserLevelService(new UserLevelRepo());
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);
        level5 = findViewById(R.id.level5);
        level6 = findViewById(R.id.level6);
        level7 = findViewById(R.id.level7);
        level8 = findViewById(R.id.level8);
        level9 = findViewById(R.id.level9);
        switch_button = findViewById(R.id.switch_button);
        Map<Integer, Button> buttonMap = new HashMap<>();
        buttonMap.put(1, level1);
        buttonMap.put(2, level2);
        buttonMap.put(3, level3);
        buttonMap.put(4, level4);
        buttonMap.put(5, level5);
        buttonMap.put(6, level6);
        buttonMap.put(7, level7);
        buttonMap.put(8, level8);
        buttonMap.put(9, level9);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            /*List<Button> levels = Arrays.asList(level1, level2, level3, level4, level5, level6, level7, level8, level9);
            userLevelService.save(new UserLevel(FirebaseAuth.getInstance().getUid(), 1));
            int level = userLevelService.getLevel(FirebaseAuth.getInstance().getUid());
            for (int i = levels.size(); i > level; i--) {
                Button button = buttonMap.get(i);
                button.setEnabled(false);
                button.setBackgroundColor(R.color.red);
            }*/
        }

        switch_button.setOnClickListener(view -> startActivity(new Intent(LevelsActivity.this, ProfileActivity.class)));
        level1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.level1) {
            startActivity(new Intent(LevelsActivity.this, FirstLevelActivity.class));
        }
    }
}