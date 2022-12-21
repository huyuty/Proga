package com.example.proga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Basket extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        TextView zakaz = findViewById(R.id.textView15);

        Intent intent = getIntent();

        String kuriza = intent.getStringExtra("kuriza");
        String svin = intent.getStringExtra("svin");
        String skuriza = intent.getStringExtra("skuriza");
        String ssvin = intent.getStringExtra("ssvin");


        zakaz.setText(kuriza);
        zakaz.setText(svin);
        zakaz.setText(skuriza);
        zakaz.setText(ssvin);

        Button back = findViewById(R.id.button15);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Basket.this, MainActivity.class);
                startActivity(back);
            }
        });

        Button oplata = findViewById(R.id.button13);
        oplata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"");
    }



}