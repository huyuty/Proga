package com.example.proga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button10);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent swither1 =new Intent(MainActivity.this, Basket.class);
                startActivity(swither1);
            }
        });

        TextView kuriza = findViewById(R.id.textView8);
        TextView svin = findViewById(R.id.textView9);
        TextView skuriza = findViewById(R.id.textView10);
        TextView ssvin = findViewById(R.id.textView7);
        Button m180 = findViewById(R.id.button4);
        Button c200 = findViewById(R.id.button5);
        Button m220 = findViewById(R.id.button6);
        Button c240 = findViewById(R.id.button7);
        Button m200 = findViewById(R.id.button8);
        Button c220 = findViewById(R.id.button9);
        Button m240 = findViewById(R.id.button2);
        Button c260 = findViewById(R.id.button3);

        m180.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m180 = new Intent(MainActivity.this,Basket.class);
                m180.putExtra("kuriza",kuriza.getText());
                startActivity(m180);
            }
        });
        c200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c200 = new Intent(MainActivity.this,Basket.class);
                c200.putExtra("kuriza",kuriza.getText());
                startActivity(c200);
            }
        });
        m220.setOnClickListener(new View.OnClickListener() {
            @Override
               public void onClick(View view) {
                    Intent m220 = new Intent(MainActivity.this,Basket.class);
                m220.putExtra("svin",svin.getText());
                startActivity(m220);
            }
        });
        c240.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c240 = new Intent(MainActivity.this,Basket.class);
                c240.putExtra("svin",svin.getText());
                startActivity(c240);
            }
        });
        m200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m200 = new Intent(MainActivity.this,Basket.class);
                m200.putExtra("skuriza",skuriza.getText());
                startActivity(m200);
            }
        });
        c220.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c220 = new Intent(MainActivity.this,Basket.class);
                c220.putExtra("skuriza",skuriza.getText());
                startActivity(c220);
            }
        });
        m240.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m240 = new Intent(MainActivity.this,Basket.class);
                m240.putExtra("ssvin",ssvin.getText());
                startActivity(m240);
            }
        });
        c260.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c260 = new Intent(MainActivity.this,Basket.class);
                c260.putExtra("ssvin",ssvin.getText());
                startActivity(c260);
            }
        });

    }


}