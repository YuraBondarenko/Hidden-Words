package com.example.hiddenwords.utils;

import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    private static final String regex = "^(.+)@(.+)$";
    private static final Pattern pattern = Pattern.compile(regex);

    public static boolean checkLogin(String login) {
        Matcher matcher = pattern.matcher(login);
        return !matcher.matches();
    }

    public static boolean checkPassword(String password) {
        return password == null || password.length() < 8;
    }

}
