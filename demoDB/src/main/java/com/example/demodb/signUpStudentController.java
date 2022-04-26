package com.example.demodb;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
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

public class signUpStudentController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler = new DBHandler();
    }

    public void signUp(ActionEvent event) throws IOException {
        String[] classes = {"Group1","Group2","Group3","Group4"};
        String insert="INSERT INTO liste(id,firstName,lastName,gender,cin,classe)"+" values(?,?,?,?,?,?)";
        connection=handler.getConnection();
        try {
            pst=connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String group = classes[new Random().nextInt(4)];
            String id = String.valueOf(new Random().nextInt(8999)+1000);
            pst.setString(1, id);
            pst.setString(2,firstName.getText());
            pst.setString(3,lastName.getText());
            if(genderMale.isSelected()) pst.setString(4,"male"); else pst.setString(4,"female");
            pst.setString(5,cinField.getText());
            pst.setString(6,group);
            System.out.println("added successfully");
            profilStudentController.infos = new String[]{firstName.getText() + " " + lastName.getText()
                    ,group,cinField.getText(),id};
            FXMLLoader loader = new FXMLLoader(getClass().getResource("profilStudent.fxml"));
            root = loader.load();
            // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            pst.executeUpdate();

        }
        catch(SQLIntegrityConstraintViolationException e){
            System.out.println("user already exists");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void backToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signInStudent.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
