package com.karon.myfirstapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        EditText edtNumber1 = (EditText) findViewById(R.id.edtNumber1);
        EditText edtNumber2 = (EditText) findViewById(R.id.edtNumber2);
        TextView txtresult = (TextView) findViewById(R.id.txtresult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(CalculateActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();
                String num1 = edtNumber1.getText().toString();
                String num2 = edtNumber2.getText().toString();
                int total = Integer.parseInt(num1) + Integer.parseInt(num2);

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://google.com"));
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:+918866555469"));
//                startActivity(intent);

//                Intent intent = new Intent(CalculateActivity.this,ResultActivity.class);
//                intent.putExtra("finaltotal",total);
////                intent.putExtra("name","ABC");
//                startActivity(intent);




                //txtresult.setText("Total = " + total);
                //Toast.makeText(CalculateActivity.this, "Total = " + total , Toast.LENGTH_SHORT).show();
            }
        });





    }
}