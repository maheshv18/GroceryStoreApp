package com.example.grocerystore_app;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class menu_p extends AppCompatActivity {

    Button v, pay;
    EditText cv, cd, cn;

    int valid = 0, total = 0;
    List<Integer> updated_cnt = new ArrayList<Integer>();
    List<String> updated_item = new ArrayList<String>();
    List<Integer> updated_price = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_p);
        v = findViewById(R.id.v);
        pay = findViewById(R.id.pay);
        cv = findViewById(R.id.cv);
        cd = findViewById(R.id.cd);
        cn = findViewById(R.id.cn);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int flag1 = 1, flag2 = 1, size = 0;
                String mob = cd.getText().toString();
                String n = cn.getText().toString();
                for (int i = 0; i < n.length(); i++) {
                    char ch = n.charAt(i);
                    if (!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z')) {
                        flag1 = 0;
                    }
                }
                try {
                    size = mob.length();
                    long num = Long.parseLong(mob);
                } catch (NumberFormatException e) {
                    flag2 = 0;
                }
                if (flag1 == 0 || n.isEmpty()) {
                    Toast.makeText(menu_p.this, "Enter your name correctly", Toast.LENGTH_SHORT).show();
                }
                if (flag2 == 0 || size != 12) {
                    Toast.makeText(menu_p.this, "Enter your card number correctly", Toast.LENGTH_SHORT).show();
                }
                if (flag1 == 1 && flag2 == 1 && size == 12) {
                    Toast.makeText(menu_p.this, "All data validated, proceed to pay", Toast.LENGTH_SHORT).show();
                    valid = 1;
                }
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(menu_p.this, "Payment successfull", Toast.LENGTH_SHORT).show();
            }
        });


    }
}


