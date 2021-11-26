package com.example.grocerystore_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Billing extends AppCompatActivity {
    Button but1,but2;
    ListView lvSummary;
    TextView tvTotal;
    Button p;
    Double Total=0d;
    int count=0,i;
    String json_obj;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper2 sqLiteHelper;
    Cursor cursor;
    ArrayList<Product> productOrders = new ArrayList<>();
    ArrayList<Product> productOrders2 = new ArrayList<>();
    ArrayList<Product> productOrders3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        lvSummary = findViewById(R.id.lvSummary);
        tvTotal = findViewById(R.id.tot);
        but1=findViewById(R.id.b1);
        but2=findViewById(R.id.b2);
        p=findViewById(R.id.pay);
        getOrderItemData();
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1=new Intent(getApplicationContext(),delivery.class);
                startActivity(b1);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b2=new Intent(getApplicationContext(), Customercare.class);
                startActivity(b2);
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pay=new Intent(getApplicationContext(), Payment.class);
                startActivity(pay);
            }
        });
    }

    private void getOrderItemData() {
        Bundle extras = getIntent().getExtras();
        if(extras !=null )
        {
            String orderItems1 = extras.getString("orderItemsf",null);
            String orderItems2 = extras.getString("orderItemsc",null);
            String orderItems3 = extras.getString("orderItemsv",null);
            if(orderItems1!=null && orderItems1.length()>0)
            {
                try{
                    JSONArray jsonOrderItems = new JSONArray(orderItems1);
                    for( i=0;i<jsonOrderItems.length();i++)
                    {
                        JSONObject jsonObject = new JSONObject(jsonOrderItems.getString(i));
                        Product product = new Product(
                                jsonObject.getString("ProductName")
                                ,jsonObject.getDouble("ProductPrice")
                                ,jsonObject.getInt("ProductImage")
                        );

                        product.CartQuantity = jsonObject.getInt("CartQuantity");

                        Total = Total + (product.CartQuantity * product.ProductPrice);
                        productOrders.add(product);
                    }
                    count=i;

                    if(productOrders.size() > 0)
                    {
                        ListAdapter listAdapter = new ListAdapter(this,productOrders);
                        lvSummary.setAdapter(listAdapter);
                        tvTotal.setText("Total Payable Bill Amount: Rs "+Total);

                    }
                    else
                    {
                        showMessage("Empty");
                    }
                }
                catch (Exception e)
                {
                    showMessage(e.toString());
                }
            }


            if(orderItems2!=null && orderItems2.length()>0)
            {
                try{
                    JSONArray jsonOrderItems2 = new JSONArray(orderItems2);
                    for(i=0;i<jsonOrderItems2.length();i++)
                    {
                        JSONObject jsonObject2 = new JSONObject(jsonOrderItems2.getString(i));
                        Product product2 = new Product(
                                jsonObject2.getString("ProductName")
                                ,jsonObject2.getDouble("ProductPrice")
                                ,jsonObject2.getInt("ProductImage")
                        );
                        product2.CartQuantity = jsonObject2.getInt("CartQuantity");

                        Total = Total + (product2.CartQuantity * product2.ProductPrice);
                        productOrders2.add(product2);
                    }
                    count=i;

                    if(productOrders2.size() > 0)
                    {
                        ListAdapter listAdapter2 = new ListAdapter(this,productOrders2);
                        lvSummary.setAdapter(listAdapter2);
                        tvTotal.setText("Total Payable Bill Amount: Rs "+Total);
                    }
                    else
                    {
                        showMessage("Empty");
                    }
                }
                catch (Exception e)
                {
                    showMessage(e.toString());
                }
            }

            if(orderItems3!=null && orderItems3.length()>0)
            {
                try{
                    JSONArray jsonOrderItems3 = new JSONArray(orderItems3);
                    for(i=0;i<jsonOrderItems3.length();i++)
                    {
                        JSONObject jsonObject3 = new JSONObject(jsonOrderItems3.getString(i));
                        Product product3 = new Product(
                                jsonObject3.getString("ProductName")
                                ,jsonObject3.getDouble("ProductPrice")
                                ,jsonObject3.getInt("ProductImage")
                        );
                        product3.CartQuantity = jsonObject3.getInt("CartQuantity");

                        Total = Total + (product3.CartQuantity * product3.ProductPrice);
                        productOrders3.add(product3);
                    }

                    if(productOrders3.size() > 0)
                    {
                        ListAdapter listAdapter2 = new ListAdapter(this,productOrders3);
                        lvSummary.setAdapter(listAdapter2);
                        tvTotal.setText("Total Payable Bill Amount: Rs "+Total);
                    }
                    else
                    {
                        showMessage("Empty");
                    }
                }
                catch (Exception e)
                {
                    showMessage(e.toString());
                }
            }
        }





    }

    public void showMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}