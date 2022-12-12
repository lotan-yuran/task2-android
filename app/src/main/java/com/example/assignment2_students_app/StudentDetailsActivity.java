package com.example.assignment2_students_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.assignment2_students_app.model.Model;
import com.example.assignment2_students_app.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        // Get the position of the current student
        Intent intent = getIntent();
        int position = Integer.parseInt(intent.getStringExtra("position"));

        // Click on edit btn
        Button btn = findViewById(R.id.studentdetails_edit_btn);
        btn.setOnClickListener(view -> {
            Intent intentEdit = new Intent(this,EditStudentActivity.class);
            // Send the position of the student
            intentEdit.putExtra("position", Integer.toString(position));
            startActivity(intentEdit);
        });

        // Pointers to all inputs
        TextView nameTv = findViewById(R.id.studentdetails_name_show_tv);
        TextView idTv = findViewById(R.id.studentdetails_id_show_tv);
        TextView phoneTv = findViewById(R.id.studentdetails_phone_show_tv);
        TextView addressTv = findViewById(R.id.studentdetails_address_show_tv);
        CheckBox checkedCb = findViewById(R.id.studentdetails_checkbox_cb);

        // Insert the data to the page
        Student current = Model.instance().getAllStudents().get(position);
        nameTv.setText(current.getName());
        idTv.setText(current.getId());
        phoneTv.setText(current.getPhone());
        addressTv.setText(current.getAddress());
        checkedCb.setChecked(current.getCb());

    }
}