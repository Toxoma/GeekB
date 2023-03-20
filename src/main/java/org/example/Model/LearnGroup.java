package org.example.Model;

import java.util.*;

public class LearnGroup extends Identification {
    private Teacher teacher;
    private List<Student> students;

    public LearnGroup(Teacher teacher, List<Student> students) {
        super();
        this.teacher = teacher;
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}
