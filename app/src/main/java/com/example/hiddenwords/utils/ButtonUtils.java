package com.example.hiddenwords.utils;

import android.os.Build;
import android.widget.Button;

import java.util.List;

public class ButtonUtils {

    public static void setButtonsEnableOrDisabled(List<Button> buttons, boolean action) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            buttons.forEach(button -> button.setEnabled(action));
        } else {
            for (Button button : buttons) {
                button.setEnabled(action);
            }
        }
    }
}
