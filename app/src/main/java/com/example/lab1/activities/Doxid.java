package com.example.lab1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1.R;

public class Doxid extends AppCompatActivity {
    private EditText Textdoxid, Textpercent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doxid_activity);

        Textdoxid = findViewById(R.id.doxid_EditText);
        Textpercent = findViewById(R.id.percent_EditText);
        Button next_button = findViewById(R.id.next_button);

        next_button.setOnClickListener(view -> {
            //Отримання чисел
            String doxid = Textdoxid.getText().toString();
            String percent = Textpercent.getText().toString();
            if (doxid.isEmpty()) {
                Toast.makeText(Doxid.this, "Значення <Дохiд> має бути заповненним.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (percent.isEmpty()) {
                Toast.makeText(Doxid.this, "Значення <Процент> має бути заповненним.", Toast.LENGTH_SHORT).show();
                return;
            }
            double percentValue;
            try {
                percentValue = Double.parseDouble(percent);
                if (percentValue < 0 || percentValue > 1) {
                    Toast.makeText(Doxid.this, "Значение <Процент> должно быть от 0 до 1.", Toast.LENGTH_SHORT).show();
                    return;
                }
            } catch (NumberFormatException e) {
                Toast.makeText(Doxid.this, "Значение <Процент> должно быть числом.", Toast.LENGTH_SHORT).show();
                return;
            }
            //Перехiд к valuts
            Intent intent = new Intent(Doxid.this, Valuts.class);
            intent.putExtra("doxid", doxid);
            intent.putExtra("percent", percent);
            startActivity(intent);
        });
    }

}
