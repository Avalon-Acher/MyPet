package com.example.acher.pet.ui;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.acher.pet.R;

/**
 * Created by Acher on 2016/1/25.
 */
public class ChatFragment extends Fragment {

    Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.activity=this.getActivity();
        super.onCreate(savedInstanceState);

        Toast.makeText(activity,"Chat",Toast.LENGTH_SHORT).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat,container,false);
    }
}

