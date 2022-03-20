package com.example.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btnBlack, btnBlue, btnPink, btnGreen, btnCount, btnReset, btnSave;
    int i = 0;
    String currentColor = "#FFFFFF";
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences("helloSharePrefs", Context.MODE_PRIVATE);
        textView = findViewById(R.id.textView);
        btnCount = findViewById(R.id.btnCount);
        btnBlack = findViewById(R.id.btnBlack);
        btnPink = findViewById(R.id.btnPink);
        btnBlue = findViewById(R.id.btnBlue);
        btnGreen = findViewById(R.id.btnGreen);
        btnSave = findViewById(R.id.btnSave);
        btnReset = findViewById(R.id.btnReset);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                textView.setText(String.valueOf(i));
            }
        });

        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#000000"));
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                currentColor = "#000000";
            }
        });

        btnPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#FF69B4"));
                currentColor = "#FF69B4";
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#03A9F4"));
                currentColor = "#03A9F4";
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#8BC34A"));
                currentColor = "#8BC34A";
            }
        });

           i = mPreferences.getInt("count", 0);
           textView.setText(String.valueOf(i));
           currentColor = mPreferences.getString("color", currentColor);
           textView.setBackgroundColor(Color.parseColor(currentColor));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putInt("count", i);
                editor.putString("color", currentColor);
                editor.apply();
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.remove("count");
                editor.remove("color");
                editor.apply();
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }

}