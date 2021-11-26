package com.example.grocerystore_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Payment extends AppCompatActivity {

    EditText name,ph,addr;
    Button vald,reg,cl,cod;
    int valid=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        name=findViewById(R.id.ename);
        ph=findViewById(R.id.eph);
        addr=findViewById(R.id.eaddr);
        vald=findViewById(R.id.v);
        reg=findViewById(R.id.reg);
        cl=findViewById(R.id.cl);
        cod=findViewById(R.id.cod);



        vald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag1=1,flag2=1,size=0;
                String mob = ph.getText().toString();
                String n = name.getText().toString();
                for (int i = 0; i < n.length(); i++) {
                    char ch = n.charAt(i);
                    if (!(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
                        flag1=0;
                    }
                }
                try {
                    size=mob.length();
                    long num = Long.parseLong(mob);
                } catch (NumberFormatException e) {
                    flag2=0;
                }
                if(flag1==0 || n.isEmpty()){
                    Toast.makeText(Payment.this, "Enter your name correctly", Toast.LENGTH_SHORT).show();
                }
                if(flag2==0 || size!=10) {
                    Toast.makeText(Payment.this, "Enter your number correctly", Toast.LENGTH_SHORT).show();
                }
                if(flag1==1 && flag2==1 && size==10)
                {
                    Toast.makeText(Payment.this, "All data validated, proceed to register", Toast.LENGTH_SHORT).show();
                    valid=1;
                }
            }
        });
        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Payment.this, "Cash on delivery accepted for your location", Toast.LENGTH_SHORT).show();
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valid==1) {
                    Toast.makeText(Payment.this, "Registering User", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), menu_p.class);
                    startActivity(intent);
                    setContentView(R.layout.activity_menu_p);
                }
            }
        });
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                ph.setText("");
                addr.setText("");
            }
        });

    }

}
