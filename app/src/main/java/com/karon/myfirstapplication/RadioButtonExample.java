package com.karon.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioButtonExample extends AppCompatActivity {


    RadioGroup rdtgrupGender;
    Button btnSubmit;
    RadioButton rdtFemale;
    CheckBox chk1,chk2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_button_example);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rdtgrupGender = (RadioGroup) findViewById(R.id.rdtgrupGender);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        rdtFemale = (RadioButton) findViewById(R.id.rdtFemale);
        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(RadioButtonExample.this, "You checked", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RadioButtonExample.this, "You not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(chk1.isChecked())
                {
                    Toast.makeText(RadioButtonExample.this, "You can proceed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RadioButtonExample.this, "Please accept terms and conditions", Toast.LENGTH_SHORT).show();
                }

//                rdtFemale.setChecked(true);

//                int checkedRadioButtonId = rdtgrupGender.getCheckedRadioButtonId();
//                if(checkedRadioButtonId<=-1)
//                {
//                    Toast.makeText(RadioButtonExample.this, "Please select gender", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    RadioButton selectedRadio = (RadioButton) findViewById(checkedRadioButtonId);
//                    Toast.makeText(RadioButtonExample.this, ""+selectedRadio.getText().toString(), Toast.LENGTH_SHORT).show();
//                }



            }
        });


    }
    public void displayData()
    {

    }
}