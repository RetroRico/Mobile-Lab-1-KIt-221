package com.example.lab1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1.R;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button begin_button = findViewById(R.id.begin_button);
        begin_button.setOnClickListener(view -> {

            //Перехід к doxid
            Intent intent = new Intent(Main.this, Doxid.class);
            startActivity(intent);
        });

        Button exit_button = findViewById(R.id.exit_button);
        exit_button.setOnClickListener(view -> finishAffinity());
    }
}
