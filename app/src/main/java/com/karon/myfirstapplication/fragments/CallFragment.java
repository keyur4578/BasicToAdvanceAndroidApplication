package com.karon.myfirstapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karon.myfirstapplication.R;

public class CallFragment extends Fragment {

    TextView txtname;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_call, container, false);
        txtname = (TextView) view.findViewById(R.id.txtname);
        Bundle bundle = getArguments();
        if(bundle!=null)
        {
            String fname = bundle.getString("fname");
            txtname.setText(fname);
        }
        return view;
    }
}