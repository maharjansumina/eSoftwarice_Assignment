package com.softwarica.esoftwarice_assignment.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.softwarica.esoftwarice_assignment.MainActivity;
import com.softwarica.esoftwarice_assignment.Model.Students;
import com.softwarica.esoftwarice_assignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    EditText etName, etAge, etAddress;
    RadioGroup rdoGender;
    Button btnSave;
    String name, address, gender = "male";
    int age;


    public StudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        etName = view.findViewById(R.id.etName);
        etAge = view.findViewById(R.id.etAge);
        etAddress = view.findViewById(R.id.etAddress);
        rdoGender = view.findViewById(R.id.rdoGender);
        btnSave = view.findViewById(R.id.btnSave);
        rdoGender.setOnCheckedChangeListener(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    name = etName.getText().toString();
                    address = etAddress.getText().toString();
                    age = Integer.parseInt(etAge.getText().toString());
                    MainActivity.studentsList.add(new Students(name,gender,age,address));
                    Toast.makeText(getContext(), "Added successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rdoMale) {
            gender = "male";
        }
        if (checkedId == R.id.rdoFemale) {
            gender = "female";
        }
        if (checkedId == R.id.rdoOthers) {
            gender = "other";
        }

    }

    private boolean validate() {
        if (TextUtils.isEmpty(etName.getText())) {
            etName.setError("Enter full name");
            etName.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etAge.getText())) {
            etAge.setError("Enter the age");
            etAge.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etAddress.getText())) {
            etAddress.setError("Enter the address");
            etAddress.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(gender)) {
            Toast.makeText(getContext(), "Select gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
