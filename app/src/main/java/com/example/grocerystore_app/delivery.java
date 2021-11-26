package com.example.grocerystore_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class delivery extends AppCompatActivity {
    Button del,store,quer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        del=findViewById(R.id.delvery);
        store=findViewById(R.id.store);
        quer=findViewById(R.id.query);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent store=new Intent(getApplicationContext(),Maptrack.class);
                startActivity(store);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
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
        quer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qr=new Intent(getApplicationContext(),Questions.class);
                startActivity(qr);
            }
        });
    }
}