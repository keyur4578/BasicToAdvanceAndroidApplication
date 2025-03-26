package com.karon.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpinnerExample extends AppCompatActivity {

    //String name = "ABC","XYZ";

    Button btnShow;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner_example);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //
        btnShow = (Button) findViewById(R.id.btnShow);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);

       //String[] department = {"Sales","Purchase","Finance","HR"};
        String[] department = getResources().getStringArray(R.array.subjects);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(SpinnerExample.this,android.R.layout.simple_spinner_item,department);
        mySpinner.setAdapter(adapter);

        //Spinner Change
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int index, long l) {
                //Toast.makeText(SpinnerExample.this, ""+index, Toast.LENGTH_SHORT).show();
                Toast.makeText(SpinnerExample.this, ""+department[index], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedValue = mySpinner.getSelectedItem().toString();
                Toast.makeText(SpinnerExample.this, ""+selectedValue, Toast.LENGTH_SHORT).show();
            }
        });



    }
}