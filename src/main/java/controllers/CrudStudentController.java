package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.School;
import models.Student;

public class CrudStudentController {
    @FXML
    private TableColumn<Student, String> colLastName;

    @FXML
    private TableColumn<Student, String> colName;

    @FXML
    private TableColumn<Student, String> colNumberPhone;

    @FXML
    private TableColumn<Student, String> colStudentCode;

    @FXML
    private TableView<Student> tbStudent;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNumberPhone;

    @FXML
    private TextField txtStudentCode;

    private School school;

    @FXML
    void deleteStudent(ActionEvent event) {
        deleteStudent();
        updateTable();
        clearFields();
    }

    @FXML
    void saveStudent(ActionEvent event) {
        saveStudent();
    }

    @FXML
    void updateStudent(ActionEvent event) {
        updateStudent();
    }

    private void deleteStudent() {
        Student student = tbStudent.getSelectionModel().getSelectedItem();
        if (student != null) {
            school.deleteStudent(student);
            updateTable();
        }
    }

    private void saveStudent() {
        if (isEmpty(txtName, txtLastName, txtStudentCode, txtNumberPhone)) {
            return;
        }

        Student student = new Student();
        if (student.existStudent(school.getListStudents(), txtStudentCode.getText())) {
            return;
        }

        setStudentData(student);
        school.addStudent(student);
        updateTable();
        clearFields();
    }

    private void updateStudent() {
        Student student = new Student();
        setStudentData(student);
        school.updateStudent(student);
        clearFields();
        updateTable();
    }

    @FXML
    void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colStudentCode.setCellValueFactory(new PropertyValueFactory<>("studentCode"));
        colNumberPhone.setCellValueFactory(new PropertyValueFactory<>("numberPhone"));

        tbStudent.setOnMouseClicked(mouseEvent -> {
            if (tbStudent.getSelectionModel().getSelectedItem() != null) {
                loadFields();
            }
        });
    }

    private void setStudentData(Student student) {
        student.setName(txtName.getText());
        student.setLastName(txtLastName.getText());
        student.setStudentCode(txtStudentCode.getText());
        student.setNumberPhone(txtNumberPhone.getText());
    }

    private void loadFields() {
        Student student = tbStudent.getSelectionModel().getSelectedItem();
        if (student != null) {
            txtName.setText(student.getName());
            txtLastName.setText(student.getLastName());
            txtStudentCode.setText(student.getStudentCode());
            txtNumberPhone.setText(student.getNumberPhone());
            txtStudentCode.setDisable(true);
        }
    }

    private void updateTable() {
        tbStudent.getItems().clear();
        tbStudent.getItems().addAll(school.getListStudents());
        tbStudent.refresh();
        txtStudentCode.setDisable(false);
    }

    private void clearFields() {
        txtName.clear();
        txtLastName.clear();
        txtStudentCode.clear();
        txtNumberPhone.clear();
        txtStudentCode.setDisable(false);
    }

    private boolean isEmpty(TextField... fields) {
        for (TextField field : fields) {
            if (field.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}