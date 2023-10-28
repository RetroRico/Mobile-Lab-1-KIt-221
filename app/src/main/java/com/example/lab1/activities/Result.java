package com.example.lab1.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1.R;

import java.util.Objects;

public class Result extends AppCompatActivity {
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        TextView TSy = findViewById(R.id.Sy_TextView);
        TextView TSc = findViewById(R.id.Sc_TextView);
        TextView TW = findViewById(R.id.W_TextView);
        TextView TSh = findViewById(R.id.Sh_TextView);
        TextView TSl = findViewById(R.id.Sl_TextView);
        TextView TH = findViewById(R.id.H_TextView);
        TextView Tr = findViewById(R.id.R_TextView);
        Button next_button = findViewById(R.id.ok_button);

        Intent intent = getIntent();
        String M = intent.getStringExtra("doxid");
        String p = intent.getStringExtra("percent");
        String valut = intent.getStringExtra("valut");
        double cstart;
        double cend;
        if(Objects.equals(valut, "Euro")){
            cstart = 39.05;
            cend = 38.64;
        }
        else{
             cstart = 40;
             cend = 37.20;
        }

        double Sy = 12 * Double.parseDouble(M);
        double Sc = Double.parseDouble(p) * Sy;
        double Ci = cstart + (10*((cend - cstart)/12));
        double W = 0;
            for(int i = 1; i <=12; i++){
                W += (Double.parseDouble(p) * Double.parseDouble(M))/Ci;
            }
        double Sh = W * cend;
        double Sl = Sy - Sc;
        double H = Sh + Sl;
        double r = H - Sy;

        TSy.setText(String.format("%.2f",Sy));
        TSc.setText(String.format("%.2f",Sc));
        TW.setText(String.format("%.2f",W));
        TSh.setText(String.format("%.2f",Sh));
        TSl.setText(String.format("%.2f",Sl));
        TH.setText(String.format("%.2f",H));
        Tr.setText(String.format("%.2f",r));

        next_button.setOnClickListener(view -> {
            //Переход к Main
            Intent intent1 = new Intent(Result.this, Main.class);
            startActivity(intent1);
        });
    }

}
