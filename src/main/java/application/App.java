package application;


import controllers.CrudStudentController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.School;
import utils.Paths;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.MANAGE_STUDENT_VIEW));
        AnchorPane pane = loader.load();

        CrudStudentController controller = loader.getController();
        controller.setSchool(new School("My School"));

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }

    // CRUD - Create, Read, Update, Delete
}
