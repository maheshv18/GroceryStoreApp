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

public class Vegetables extends AppCompatActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    ArrayList<Product> products = new ArrayList<>();
    Button btnPlaceOrder;
    ArrayList<Product> productOrders = new ArrayList<>();
    ArrayList<String> lIt = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);
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
        back.putExtra("orderItemsv",orderItems);
        startActivity(back);

    }

    private void showMessage(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    public void getProduct() {
        products.add(new Product("Beans",90.0,R.mipmap.beans));
        products.add(new Product("BeetRoot",140.0,R.mipmap.beetroot));
        products.add(new Product("Carrot",35.0,R.mipmap.carrot));
        products.add(new Product("Lemon",65.0,R.mipmap.lemon));
        products.add(new Product("Onion",55.0,R.mipmap.onion));
        products.add(new Product("Potato",110.0,R.mipmap.potato));
        products.add(new Product("Tomato",110.0,R.mipmap.tomota));
        products.add(new Product("Cauliflower",110.0,R.mipmap.califlower));



    }
}