package com.example.guitorio.roompersistancelibrary;


import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView tvDisplay;

    private RecyclerView recyclerView;
    private UserDisplayAdapter userDisplayAdapter;
    private List<User> usersArrayList = new ArrayList<>();


    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);

        tvDisplay = view.findViewById(R.id.tvDisplay);

        recyclerView = view.findViewById(R.id.recyclerViewUserList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        List<User> usersDatabase = MainActivity.myAppDatabse.myDao().getUsers();

        String info = "";
        String single = "";

        for (User user : usersDatabase){
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info+"\n\n"+" Id: "+id+"\n Name: "+name+"\n Email: "+email;

            single = "\n\n"+" Id: "+id+"\n Name: "+name+"\n Email: "+email;

            /*
            * ============ Recyclerview ===============
            * */

            User usersModel = new User();

            usersModel.setId(id);
            usersModel.setName(name);
            usersModel.setEmail(email);

            usersArrayList.add(usersModel);

            Log.d(TAG, "onCreateView: Each Users: "+single);

            /*
             * ============ Recyclerview ===============
             * */
        }

        tvDisplay.setText(info);

        userDisplayAdapter = new UserDisplayAdapter(getActivity(),usersArrayList);
        recyclerView.setAdapter(userDisplayAdapter);



        return view;
    }

}
