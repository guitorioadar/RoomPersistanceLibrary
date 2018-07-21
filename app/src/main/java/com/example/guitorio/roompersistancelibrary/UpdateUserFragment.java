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
public class UpdateUserFragment extends Fragment {

    private EditText userId,userName,userEmail;
    private Button btnUpdateUser;

    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);

        userId = view.findViewById(R.id.et_user_id_update);
        userName = view.findViewById(R.id.et_name_update);
        userEmail = view.findViewById(R.id.et_email_update);
        btnUpdateUser = view.findViewById(R.id.btn_update);

        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(userId.getText().toString());
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();


                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabse.myDao().updateUser(user);

                Toast.makeText(getActivity(), "User successfully updated...", Toast.LENGTH_SHORT).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");


            }
        });

        return view;
    }

}
