package com.karon.myfirstapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.karon.myfirstapplication.R;


public class HomeFragment extends Fragment {

    Button btnprofile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnprofile=(Button) view.findViewById(R.id.btnprofile);
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(getActivity(),btnprofile);
                popup.getMenuInflater().inflate(R.menu.bottom_menu,popup.getMenu());

                popup.setOnMenuItemClickListener(item -> {

//                    switch(item.getItemId())
//                    {
//                        case R.id.nav_home:
//                            Toast.makeText(getActivity(), "Home Menu", Toast.LENGTH_SHORT).show();
//                            return true;
//                        case R.id.nav_setting:
//                            Toast.makeText(getActivity(), "Setting Menu", Toast.LENGTH_SHORT).show();
//                            return true;
//                        default:
//                            return false;
//
//                    }

                    if(item.getItemId() == R.id.nav_home)
                    {
                        Toast.makeText(getActivity(), "Home Menu", Toast.LENGTH_SHORT).show();
                    }
                    else if(item.getItemId() == R.id.nav_setting)
                    {
                        Toast.makeText(getActivity(), "Setting Menu", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                });

                popup.show();
            }
        });
        return view;
    }
}