package com.example.guitorio.roompersistancelibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button btnAddUser,btnViewUser,btnUpdateUser,btnDeleteUser;

    private RecyclerView recyclerView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        btnAddUser = view.findViewById(R.id.btnAddUser);
        btnViewUser = view.findViewById(R.id.btnVIewUser);
        btnUpdateUser = view.findViewById(R.id.btnUpdateUser);
        btnDeleteUser = view.findViewById(R.id.btnDeleteUser);


        btnAddUser.setOnClickListener(this);
        btnViewUser.setOnClickListener(this);
        btnUpdateUser.setOnClickListener(this);
        btnDeleteUser.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnAddUser: {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new AddUserFragment()).addToBackStack(null).commit();
                break;
            }

            case R.id.btnVIewUser: {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new ReadUserFragment()).addToBackStack(null).commit();
                break;
            }

            case R.id.btnUpdateUser: {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new UpdateUserFragment()).addToBackStack(null).commit();
                break;
            }

            case R.id.btnDeleteUser: {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new DeleteUserFragment()).addToBackStack(null).commit();
                break;
            }

        }

    }
}
