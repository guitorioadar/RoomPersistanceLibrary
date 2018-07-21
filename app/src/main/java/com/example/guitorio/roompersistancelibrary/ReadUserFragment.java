package com.example.guitorio.roompersistancelibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView tvDisplay;


    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);

        tvDisplay = view.findViewById(R.id.tvDisplay);

        List<User> users = MainActivity.myAppDatabse.myDao().getUsers();

        String info = "";
        String single = "";

        for (User user : users){
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info+"\n\n"+" Id: "+id+"\n Name: "+name+"\n Email: "+email;

            single = "\n\n"+" Id: "+id+"\n Name: "+name+"\n Email: "+email;

            Log.d(TAG, "onCreateView: Each Users: "+single);

        }
        tvDisplay.setText(info);

        return view;
    }

}
