package org.example.Controller;

import org.example.Model.LearnGroup;
import org.example.Model.Student;
import org.example.Model.Teacher;
import org.example.Service.LearnGroupService;

import java.util.ArrayList;
import java.util.List;

public class LearnGroupController extends LearnGroupService {
    public LearnGroup createLearnGroup(Teacher teacher, List<Student> students){
      return super.createLearnGroup(teacher, students);
    }

    public List<Integer> getLearnGroupStudentsIds(LearnGroup learnGroup){
        List<Integer> ids = new ArrayList<>();
        for (Student student: learnGroup.getStudents()) {
            ids.add(student.getId());
        }
        return ids;
    }
    public int getLearnGroupTeacherId(LearnGroup learnGroup){
        return learnGroup.getTeacher().getId();
    }
}
