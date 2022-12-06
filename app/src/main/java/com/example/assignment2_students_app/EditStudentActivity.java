package com.example.assignment2_students_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.assignment2_students_app.model.Model;
import com.example.assignment2_students_app.model.Student;

public class EditStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        Intent intent = getIntent();
        int position = Integer.parseInt(intent.getStringExtra("position"));
        Log.d("LOTAN", "posssss " + position);

        TextView nameEt = findViewById(R.id.editstudent_name_et);
        TextView idEt = findViewById(R.id.editstudent_id_et);
        TextView phoneEt = findViewById(R.id.editstudent_phone_et);
        TextView addressEt = findViewById(R.id.editstudent_address_et);
        CheckBox checkedCb = findViewById(R.id.editstudent_checkbox_cb);

        Student current = Model.instance().getAllStudents().get(position);
        nameEt.setText(current.getName());
        idEt.setText(current.getId());
        phoneEt.setText(current.getPhone());
        addressEt.setText(current.getAddress());
        checkedCb.setChecked(current.getCb());
    }
}