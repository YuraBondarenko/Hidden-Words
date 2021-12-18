package com.example.hiddenwords;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiddenwords.utils.WordUtils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SecondLevelActivity extends AppCompatActivity {
    private Button check_word;
    private Button back_to_levels;
    private TextView first_word;
    private TextView second_word;
    private TextView third_word;
    private TextView fourth_word;

    private EditText word;
    private List<String> correctWords;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_level);

        check_word = findViewById(R.id.check_word);
        back_to_levels = findViewById(R.id.back_to_levels);
        word = findViewById(R.id.word);
        first_word = findViewById(R.id.first_word);
        second_word = findViewById(R.id.second_word);
        third_word = findViewById(R.id.third_word);
        fourth_word = findViewById(R.id.fourth_word);
        correctWords = new ArrayList<>(Arrays.asList(first_word.getText().toString().toLowerCase(), second_word.getText().toString().toLowerCase(),
                third_word.getText().toString().toLowerCase(), fourth_word.getText().toString().toLowerCase()));
        Map<String, TextView> buttonMap = new HashMap<>();
        buttonMap.put(first_word.getText().toString().toLowerCase(), first_word);
        buttonMap.put(second_word.getText().toString().toLowerCase(), second_word);
        buttonMap.put(third_word.getText().toString().toLowerCase(), third_word);
        buttonMap.put(fourth_word.getText().toString().toLowerCase(), fourth_word);


        back_to_levels.setOnClickListener(s -> startActivity(new Intent(SecondLevelActivity.this, LevelsActivity.class)));

        check_word.setOnClickListener(s -> {
            String text = word.getText().toString();
            if (correctWords.contains(text.toLowerCase())) {
                Toast.makeText(getApplicationContext(), WordUtils.encouragements.get(new Random().nextInt(WordUtils.encouragements.size())), Toast.LENGTH_SHORT).show();
                correctWords.remove(text.toLowerCase());
                if (buttonMap.containsKey(text.toLowerCase())) {
                    buttonMap.get(text.toLowerCase()).setTextColor(R.color.red);
                }
            } else {
                Toast.makeText(getApplicationContext(), R.string.try_one_more_time, Toast.LENGTH_SHORT).show();
            }
            word.setText("");
            if (correctWords.isEmpty()) {
                Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_LONG).show();
                startActivity(new Intent(SecondLevelActivity.this, LevelsActivity.class));
            }
        });
    }
}