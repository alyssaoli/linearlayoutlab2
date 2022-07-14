package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView firstText = findViewById(R.id.firstText);
        Switch toggleSwitch = findViewById(R.id.toggleSwitch);
        ImageButton flag = findViewById(R.id.flag);
        Button myButton = findViewById(R.id.myButton);
        CheckBox myCheckBox = findViewById(R.id.checkb);
        EditText editText = findViewById(R.id.theEdit);

        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstText.setText(editText.getText());
                Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
            }
        });
        myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String text = "";
                if (b) text = "on";
                else text = "off";

                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "The Checkbox is now " + text, Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCheckBox.setChecked(!b);
                            }
                        });

                snackbar.show();
            }
        });
    }
}
