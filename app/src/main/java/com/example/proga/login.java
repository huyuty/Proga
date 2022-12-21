package com.example.proga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://dostavkabase-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switcher = new Intent(login.this, LoginEmp.class);
                startActivity(switcher);
            }
        });

        final EditText phone = findViewById(R.id.textView3);
        final EditText address = findViewById(R.id.textView5);
        final Button login = findViewById(R.id.button11);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String phoneTxt = phone.getText().toString();
                final String addresstxt = address.getText().toString();

                if(phoneTxt.isEmpty() || addresstxt.isEmpty()){
                    Toast.makeText(login.this, "Пожалуйста, введите ваш номер и адрес", Toast.LENGTH_SHORT).show();
                }
                else{

                    databaseReference.child("Client").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phoneTxt)){

                                final String getAddress = snapshot.child(phoneTxt).child("address").getValue(String.class);

                                assert getAddress != null;
                                if(getAddress.equals(addresstxt)){
                                    Toast.makeText(login.this, "Успешный вход", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(com.example.proga.login.this,MainActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(login.this, "Вы не являетесь частью нашего сервиса", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(login.this, "Вы не являетесь частью нашего сервиса", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }



}