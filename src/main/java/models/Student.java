package models;

import java.util.ArrayList;

public class Student {
    private String name;
    private String studentCode;
    private String lastName;
    private String numberPhone;

    public Student(String name, String studentCode, String numberPhone, String lastName) {
        this.name = name;
        this.studentCode = studentCode;
        this.numberPhone = numberPhone;
        this.lastName = lastName;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public boolean existStudent(ArrayList<Student> listStudents, String text) {
        for (Student student: listStudents) {
            if(student.getStudentCode().equals(text)) {
                return true;
            }
        }
        return false;
    }
}
