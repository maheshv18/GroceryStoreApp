package com.example.grocerystore_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grocerystore_app.Billing;
import com.example.grocerystore_app.Product;

import org.json.JSONArray;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    ArrayList<Product> products = new ArrayList<>();
    Button btnPlaceOrder;
    ArrayList<Product> productOrders = new ArrayList<>();
    ArrayList<String> lIt = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getProduct();
        listView = (ListView) findViewById(R.id.customListView);
        listAdapter = new ListAdapter(this,products);
        listView.setAdapter(listAdapter);
        btnPlaceOrder = (Button) findViewById(R.id.btnPlaceOrder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
    }

    private void placeOrder()
    {
        productOrders.clear();
        lIt.clear();


        for(int i=0;i<listAdapter.listProducts.size();i++)
        {
            if(listAdapter.listProducts.get(i).CartQuantity > 0)
            {
                Product products = new Product(
                        listAdapter.listProducts.get(i).ProductName
                        ,listAdapter.listProducts.get(i).ProductPrice
                        ,listAdapter.listProducts.get(i).ProductImage
                );
                products.CartQuantity = listAdapter.listProducts.get(i).CartQuantity;
                productOrders.add(products);

                lIt.add(products.getJsonObject().toString());
            }
        }

        JSONArray jsonArray = new JSONArray(lIt);
        openSummary(jsonArray.toString());
    }

    private void openSummary(String orderItems) {
        Intent back = new Intent(this, Fruits.class);
        back.putExtra("orderItemsf",orderItems);
        startActivity(back);

    }

    private void showMessage(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    public void getProduct() {
        products.add(new Product("Apple",90.0,R.mipmap.apple));
        products.add(new Product("Mango",140.0,R.mipmap.mango));
        products.add(new Product("Bananas",35.0,R.mipmap.banana));
        products.add(new Product("PineApple",65.0,R.mipmap.pineapple));
        products.add(new Product("Guava",55.0,R.mipmap.guava));
        products.add(new Product("Grapes",110.0,R.mipmap.grapes));



    }
}