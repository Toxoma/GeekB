package org.example.Service;

import org.example.Model.LearnGroup;
import org.example.Model.Student;
import org.example.Model.Teacher;

import java.util.List;

public class LearnGroupService {
    protected LearnGroup createLearnGroup(Teacher teacher, List<Student> students){
        return new LearnGroup(teacher, students);
    }
}
