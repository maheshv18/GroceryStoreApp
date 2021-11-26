package com.example.grocerystore_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Customercare extends AppCompatActivity {
    Button bu1,bu2,bu3,bu4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customercare);
        bu1=findViewById(R.id.bu1);
        bu2=findViewById(R.id.bu2);
        bu3=findViewById(R.id.bu3);
        bu4=findViewById(R.id.bu4);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                Intent billing=new Intent(getApplicationContext(),Billing.class);
                String orderItems1 = extras.getString("orderItemsf",null);
                String orderItems2 = extras.getString("orderItemsc",null);
                String orderItems3 = extras.getString("orderItemsv",null);
                billing.putExtra("orderItemsf",orderItems1);
                billing.putExtra("orderItemsc",orderItems2);
                billing.putExtra("orderItemsv",orderItems3);
                startActivity(billing);
            }
        });
        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bu3=new Intent(getApplicationContext(),Questions.class);
                startActivity(bu3);
            }
        });
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bu2=new Intent(getApplicationContext(),offers.class);
                startActivity(bu2);
            }
        });
        bu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bu4=new Intent(getApplicationContext(),Report.class);
                startActivity(bu4);
            }
        });
    }
}