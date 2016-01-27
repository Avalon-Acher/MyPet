package com.example.acher.pet.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.acher.pet.R;

/**
 * Created by Acher on 2016/1/25.
 */
public class PetFragment extends Fragment {
    Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.activity=this.getActivity();
        super.onCreate(savedInstanceState);
        Toast.makeText(activity, "Pet", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pet,container,false);
    }
}
