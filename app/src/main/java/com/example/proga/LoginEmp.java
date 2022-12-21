package com.example.proga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class LoginEmp extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://dostavkabase-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_emp);

         final EditText login = findViewById(R.id.textView6);
         final EditText password = findViewById(R.id.textView7);
         final Button loginIn = findViewById(R.id.button12);

        loginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String loginTxt = login.getText().toString();
                final String passwordTxt = password.getText().toString();

                if(loginTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(LoginEmp.this, "Пожалуйста, введите ваш номер и адрес", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("Staff").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(loginTxt)){

                                final String getPassword =snapshot.child(loginTxt).child("password").getValue(String.class);

                                assert getPassword != null;
                                if(getPassword.equals(passwordTxt)){
                                    Toast.makeText(LoginEmp.this, "Успешный вход", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginEmp.this,Admin.class));
                                    finish();
                                }
                                else {
                                    Toast.makeText(LoginEmp.this, "Вы не являетесь частью нашего сервиса", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(LoginEmp.this, "Вы не являетесь частью нашего сервиса", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    databaseReference.child("Staff1").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(loginTxt)){

                                final String getPassword =snapshot.child(loginTxt).child("password1").getValue(String.class);

                                assert getPassword != null;
                                if(getPassword.equals(passwordTxt)){
                                    Toast.makeText(LoginEmp.this, "Успешный вход", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginEmp.this,Dostavka.class));
                                    finish();
                                }
                                else {
                                    Toast.makeText(LoginEmp.this, "Вы не являетесь частью нашего сервиса", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(LoginEmp.this, "Вы не являетесь частью нашего сервиса", Toast.LENGTH_SHORT).show();
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