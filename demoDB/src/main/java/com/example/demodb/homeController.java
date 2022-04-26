package com.example.demodb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class homeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button exitBtn;


    public void signAsStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signInStudent.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void signAsTeacher(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signInTeacher.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void aboutus(ActionEvent event) throws  IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("aboutus.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void exit(ActionEvent event) throws IOException{
        System.exit(1);
    }
    public void backtoHome(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
