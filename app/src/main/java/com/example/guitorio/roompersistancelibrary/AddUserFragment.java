package com.example.guitorio.roompersistancelibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText userId,userName,userEmail;
    private Button btnSaveUser;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        userId = view.findViewById(R.id.et_user_id);
        userName = view.findViewById(R.id.et_name);
        userEmail = view.findViewById(R.id.et_email);
        btnSaveUser = view.findViewById(R.id.btn_save);

        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(userId.getText().toString());
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();

                try {
                    User user = new User();
                    user.setId(id);
                    user.setName(name);
                    user.setEmail(email);

                    MainActivity.myAppDatabse.myDao().addUser(user);
                    Toast.makeText(getActivity(), "User Added Successfully", Toast.LENGTH_SHORT).show();

                    userId.setText("");
                    userName.setText("");
                    userEmail.setText("");
                }catch (Exception e){
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }



            }
        });

        return view;
    }

}
