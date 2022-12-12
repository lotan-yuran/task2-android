package com.example.assignment2_students_app.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        addStudent(new Student("Lotan", "322592973", "", "0543399036", "mazor", false));
        addStudent(new Student("Avi", "545429735", "", "0525399036", "Ramat Gan", true));
        addStudent(new Student("Eli", "654853956", "", "0546543236", "Haifa", false));
        addStudent(new Student("Tom", "657439864", "", "0543399123", "Tel aviv", true));
        addStudent(new Student("Alex", "987654321", "", "0543123456", "Shoham", false));
    }

    List<Student> data = new LinkedList<>();
    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student st) {
        data.add(st);
    }
}
