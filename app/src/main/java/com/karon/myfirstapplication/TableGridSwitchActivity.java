package com.karon.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class TableGridSwitchActivity extends AppCompatActivity {

    Switch switchWifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table_grid_switch);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        switchWifi = (Switch) findViewById(R.id.switchWifi);
        BottomSheetDialog dialog = new BottomSheetDialog(TableGridSwitchActivity.this);
        View view =  getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
        Button btn1 = (Button)  view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TableGridSwitchActivity.this, "Call Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setContentView(view);

        switchWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    dialog.show();
                   // Toast.makeText(TableGridSwitchActivity.this, "Wifi On", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dialog.hide();
                    //Toast.makeText(TableGridSwitchActivity.this, "Wifi Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}