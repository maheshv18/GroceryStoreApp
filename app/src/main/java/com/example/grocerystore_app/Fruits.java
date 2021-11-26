package com.example.grocerystore_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Fruits extends AppCompatActivity {
    Button f,c,v,checkot;
    ListView lvSummary;
    TextView tvTotal;
    Double Total=0d;
    ArrayList<Product> productOrders = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        f=findViewById(R.id.fruits1);
        c=findViewById(R.id.crops);
        v=findViewById(R.id.vegetables);
        checkot=findViewById(R.id.checkout);

        Bundle extras = getIntent().getExtras();


        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFruits=new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intentFruits);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCrops=new Intent(getApplicationContext(),ActivityCrops.class);
                startActivity(intentCrops);
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVeggies=new Intent(getApplicationContext(),Vegetables.class);
                startActivity(intentVeggies);
            }
        });
        checkot.setOnClickListener(new View.OnClickListener() {
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
    }

    private void showMessage(String toString) {
        Toast.makeText(this,toString,Toast.LENGTH_LONG).show();
    }
}