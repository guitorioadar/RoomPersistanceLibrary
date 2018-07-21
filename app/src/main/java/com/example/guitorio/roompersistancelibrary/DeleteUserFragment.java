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
public class DeleteUserFragment extends Fragment {

    private EditText etUserId;
    private Button btnDelete;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        etUserId = view.findViewById(R.id.et_user_id_delete);
        btnDelete = view.findViewById(R.id.btn_delete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(etUserId.getText().toString());

                User user = new User();
                user.setId(id);

                MainActivity.myAppDatabse.myDao().deleteUser(user);

                Toast.makeText(getActivity(), "User Successfully Deleted", Toast.LENGTH_SHORT).show();
                etUserId.setText("");

            }
        });

        return view;
    }

}
