package com.example.assignment2_students_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.assignment2_students_app.model.Model;
import com.example.assignment2_students_app.model.Student;

public class EditStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        // Get the position of the current student
        Intent intent = getIntent();
        int position = Integer.parseInt(intent.getStringExtra("position"));

        // Pointers to all inputs
        TextView nameEt = findViewById(R.id.editstudent_name_et);
        TextView idEt = findViewById(R.id.editstudent_id_et);
        TextView phoneEt = findViewById(R.id.editstudent_phone_et);
        TextView addressEt = findViewById(R.id.editstudent_address_et);
        CheckBox checkedCb = findViewById(R.id.editstudent_checkbox_cb);

        // Insert the data to the inputs
        Student current = Model.instance().getAllStudents().get(position);
        nameEt.setText(current.getName());
        idEt.setText(current.getId());
        phoneEt.setText(current.getPhone());
        addressEt.setText(current.getAddress());
        checkedCb.setChecked(current.getCb());

        // Save click
        Button saveBtn = findViewById(R.id.editstudent_save_btn);
        saveBtn.setOnClickListener(view -> {
            current.setName(nameEt.getText().toString());
            current.setId(idEt.getText().toString());
            current.setPhone(phoneEt.getText().toString());
            current.setAddress(addressEt.getText().toString());
            current.setCb(checkedCb.isChecked());
            Intent intentEdit = new Intent(this,StudentRecyclerList.class);
            startActivity(intentEdit);
        });

        // Cancel click
        Button cancelBtn = findViewById(R.id.editstudent_cancel_btn);
        cancelBtn.setOnClickListener(view -> {
            finish();
        });

        // Delete click
        Button deleteBtn = findViewById(R.id.editstudent_delete_btn);
        deleteBtn.setOnClickListener(view -> {
            Model.instance().getAllStudents().remove(position);
            Intent intentToList = new Intent(this,StudentRecyclerList.class);
            startActivity(intentToList);
        });



    }
}