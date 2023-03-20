package org.example;

import org.example.Controller.LearnGroupController;
import org.example.Model.LearnGroup;
import org.example.Model.Student;
import org.example.Model.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LearnGroupController learnGroupController = new LearnGroupController();

        Teacher teacher = new Teacher("Dave");
        Student student_1 = new Student("Mike");
        Student student_2 = new Student("Daniel");
        Student student_3 = new Student("Angella");
        Student student_4 = new Student("Kris");
        List<Student> students = new ArrayList<>(Arrays.asList(student_1, student_2, student_3, student_4));
        LearnGroup learnGroup = learnGroupController.createLearnGroup(teacher, students);

        System.out.println("!!!!");
        System.out.println(learnGroupController.getLearnGroupTeacherId(learnGroup));
        System.out.println("_______");
        for (int id: learnGroupController.getLearnGroupStudentsIds(learnGroup)) {
            System.out.println(id);
        }
    }
}