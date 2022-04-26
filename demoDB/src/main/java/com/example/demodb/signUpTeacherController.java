package com.example.demodb;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import com.example.demodb.DBConnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class signUpTeacherController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField cityField;
    @FXML
    private TextField cinField;
    @FXML
    private RadioButton genderMale;
    @FXML
    private RadioButton genderFemale;
    @FXML
    private TextField subjectField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler = new DBHandler();
    }

    public void signUp(ActionEvent event) throws IOException {
        String insert="INSERT INTO listteachers(id,firstName,lastName,gender,city,matiere,cin)"+" values(?,?,?,?,?,?,?)";
        connection=handler.getConnection();
        try {
            pst=connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String id = String.valueOf(new Random().nextInt(8999)+1000);
            pst.setString(1, id);
            pst.setString(2,firstName.getText());
            pst.setString(3,lastName.getText());
            if(genderMale.isSelected()) pst.setString(4,"male"); else pst.setString(4,"female");
            pst.setString(5,cityField.getText());
            pst.setString(6,subjectField.getText());
            pst.setString(7,cinField.getText());
            System.out.println("added successfully");
            profilTeacherController.infos =new String[] {firstName.getText()+" "+lastName.getText(),cityField.getText()
            ,subjectField.getText(),cinField.getText(),id};
            FXMLLoader loader = new FXMLLoader(getClass().getResource("profilTeacher.fxml"));
            root = loader.load();
            // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void backToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signInTeacher.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
