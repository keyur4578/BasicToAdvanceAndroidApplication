package com.karon.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.karon.myfirstapplication.fragments.CallFragment;
import com.karon.myfirstapplication.fragments.ChatFragment;

public class FragmentExampleActivity extends AppCompatActivity {


    Button btnchat,btncall;
    EditText edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_example2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnchat = (Button)findViewById(R.id.btnchat);
        btncall = (Button)findViewById(R.id.btncall);
        edtName = (EditText)findViewById(R.id.edtName);

        loadFragment(new ChatFragment(),R.id.fragmentContainer1,"");

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm = edtName.getText().toString();
                loadFragment(new CallFragment(),R.id.fragmentContainer1,nm);
            }
        });
        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ChatFragment(),R.id.fragmentContainer1,"");
            }
        });

    }

    public void loadFragment(Fragment fragment,int resourceid,String nm)
    {
        Bundle bundle = new Bundle();
        bundle.putString("fname",nm);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(resourceid,fragment);
        fragmentTransaction.commit();
    }

}