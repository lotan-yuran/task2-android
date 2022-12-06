package com.example.assignment2_students_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.assignment2_students_app.model.Model;
import com.example.assignment2_students_app.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        // Pointer to the inputs and buttons
        EditText nameEt = findViewById(R.id.addstudent_name_et);
        EditText idEt = findViewById(R.id.addstudent_id_et);
        EditText phoneEt = findViewById(R.id.addstudent_phone_et);
        EditText addressEt = findViewById(R.id.addstudent_phone_et);
        CheckBox checkedCb = findViewById(R.id.addstudent_checkbox_cb);
        Button saveBtn = findViewById(R.id.addstudent_save_btn);
        Button cancelBtn = findViewById(R.id.addstudent_cancell_btn);

        // Click add
        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            String id = idEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String address = addressEt.getText().toString();
            Boolean checked = checkedCb.isChecked();
            Model.instance().addStudent(new Student(name, id, "", phone, address, checked));
            Intent intent = new Intent(this,StudentRecyclerList.class);
            startActivity(intent);
        });

        // Click cancel
        cancelBtn.setOnClickListener(view -> finish());
    }
}