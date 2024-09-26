package models;

import java.util.ArrayList;

public class School {
    private String name;
    private ArrayList<Student> listStudents;

    public School(String name) {
        this.name = name;
        this.listStudents = new ArrayList<>();
    }

    public void addStudent(Student student) {
        listStudents.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public void deleteStudent(Student student) {
        listStudents.remove(student);
    }

    public void updateStudent(Student student) {
        for (Student itemStudent: listStudents) {
            if(itemStudent.getStudentCode().equals(student.getStudentCode())) {
                itemStudent.setName(student.getName());
                itemStudent.setLastName(student.getLastName());
                itemStudent.setNumberPhone(student.getNumberPhone());
            }
        }
    }
}
