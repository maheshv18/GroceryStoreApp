package com.example.grocerystore_app;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    public ArrayList<Product> listProducts;
    private Context context;
    public ListAdapter(Context context,ArrayList<Product> listProducts) {
        this.context = context;
        this.listProducts = listProducts;
    }

    @Override
    public int getCount() {
        return listProducts.size();
    }

    @Override
    public Product getItem(int position) {
        return listProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView
            , ViewGroup parent) {
        View row;
        final ListViewHolder listViewHolder;
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_custom_listview,parent,false);
            listViewHolder = new ListViewHolder();
            listViewHolder.PN = row.findViewById(R.id.tvProductName);
            listViewHolder.PI = row.findViewById(R.id.ivProduct);
            listViewHolder.PP = row.findViewById(R.id.tvPrice);
            listViewHolder.BtAdd = row.findViewById(R.id.ib_addnew);
            listViewHolder.Quantity = row.findViewById(R.id.editTextQuantity);
            listViewHolder.BtSub = row.findViewById(R.id.ib_remove);
            row.setTag(listViewHolder);
        }
        else
        {
            row=convertView;
            listViewHolder= (ListViewHolder) row.getTag();
        }
        final Product products = getItem(position);

        listViewHolder.PN.setText(products.ProductName);
        listViewHolder.PI.setImageResource(products.ProductImage);
        listViewHolder.PP.setText(products.ProductPrice+" Rs");
        listViewHolder.Quantity.setText(products.CartQuantity+"");
        listViewHolder.BtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                updateQuantity(position,listViewHolder.Quantity,1);
            }
        });

        listViewHolder.BtSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuantity(position,listViewHolder.Quantity,-1);
            }
        });

        return row;
    }

    private void updateQuantity(int position, EditText edTextQuantity, int value) {

        Product products = getItem(position);
        if(value > 0)
        {
            products.CartQuantity = products.CartQuantity + 1;
        }
        else
        {
            if(products.CartQuantity > 0)
            {
                products.CartQuantity = products.CartQuantity - 1;
            }
        }
        edTextQuantity.setText(products.CartQuantity+"");
    }
}