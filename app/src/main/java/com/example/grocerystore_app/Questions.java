package com.example.grocerystore_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Questions extends AppCompatActivity {
    Button bb1,bb2,bb3,bb4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        bb1=findViewById(R.id.q1);
        bb2=findViewById(R.id.q2);
        bb3=findViewById(R.id.q3);
        bb4=findViewById(R.id.q4);
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Within 7 working days",Toast.LENGTH_SHORT).show();
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You can cancel your delivery at any time ",Toast.LENGTH_SHORT).show();
            }
        });
        bb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Please go to deliveryinfo ",Toast.LENGTH_SHORT).show();
            }
        });
        bb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Please following steps->delivery->stores near me",Toast.LENGTH_SHORT).show();
            }
        });
    }
}