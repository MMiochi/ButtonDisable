package com.example.buttondisable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonDisable;
    private Button buttonEnable;
    private Button buttonReset;
    private TextView txtCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
        }

        txtCount = findViewById(R.id.textView);
        txtCount.setText("Naciśnięto przycisk " + count + " razy");

        buttonDisable = findViewById(R.id.buttonDisable);
        buttonDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDisable.setEnabled(false);
                count++;
                txtCount.setText("Naciśnięto przycisk " + count + " razy");
                Toast.makeText(MainActivity.this, "Przycisk został wyłączony", Toast.LENGTH_SHORT).show();
            }
        });

        buttonEnable = findViewById(R.id.buttonEnable);
        buttonEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDisable.setEnabled(true);
            }
        });

        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                txtCount.setText("Naciśnięto przycisk " + count + " razy");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("count", count);
    }
}