package org.example.Model;

import java.util.*;

// Dependency Inversion Principle
public class LearnGroup extends Identification {
    private Teacher teacher;
    private List<Student> students;

    /*
    * Open Closed Principle
    * расширение родительского функционала
    */
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
