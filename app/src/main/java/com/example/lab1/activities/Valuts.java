package com.example.lab1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1.R;

public class Valuts extends AppCompatActivity {
    private Button ResultButton;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valuts_activity);

        Intent intent = getIntent();
        final String doxid = intent.getStringExtra("doxid");
        final String percent = intent.getStringExtra("percent");

        ResultButton = findViewById(R.id.result_button);
        spinner = findViewById(R.id.valute_choice_Spinner);

        String[] types = {"Euro", "Dollar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        spinner.setAdapter(adapter);

        ResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valut = spinner.getSelectedItem().toString();
                //Переход к Result
                Intent intent = new Intent(Valuts.this, Result.class);
                intent.putExtra("doxid", doxid);
                intent.putExtra("percent", percent);
                intent.putExtra("valut", valut);
                startActivity(intent);
            }
        });
    }
}
