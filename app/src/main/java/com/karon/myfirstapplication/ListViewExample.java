package com.karon.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewExample extends AppCompatActivity {

//    ListView myListView;
    GridView myGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_example);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       // myListView = (ListView) findViewById(R.id.myListView);
        myGridView = (GridView) findViewById(R.id.myGridView);
        String[] department = {"Sales","Purchase","Finance","HR","Sales","Purchase","Finance","HR","Sales","Purchase","Finance","HR","Sales","Purchase","Finance","HR","Sales","Purchase","Finance","HR"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListViewExample.this,R.layout.list_item,department);
        myGridView.setAdapter(adapter);

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = department[i];
                Toast.makeText(ListViewExample.this, ""+selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

    }
}