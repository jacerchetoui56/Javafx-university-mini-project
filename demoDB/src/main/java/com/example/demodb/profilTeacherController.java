package com.example.demodb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class profilTeacherController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label cinField;

    @FXML
    private Label fullName;

    @FXML
    private Label groupField;

    @FXML
    private Label idField;

    @FXML
    private Button infosBtn;

    @FXML
    private Label cityField;
    @FXML
    private Label matiereField;

    public static String[] infos ;

    public void displayInfos(){
        System.out.println("clicked");
        fullName.setText(infos[0]);
        cityField.setText(infos[1]);
        cinField.setText(infos[3]);
        idField.setText(infos[4]);
        matiereField.setText(infos[2]);
        infosBtn.setStyle("-fx-text-fill : blue; -fx-background-color : #eaf2ff ; -fx-background-radius: 13;");
    }
    public void logout(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signInTeacher.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showListOfGroups(ActionEvent event) throws IOException{
        listTeacherController.whichList = "Group1";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("groupList1.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToInfos(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profilteacher.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showTable1(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeTableForTeacher1.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showTable2(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeTableForTeacher2.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showTable3(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeTableForTeacher3.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showTable4(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeTableForTeacher4.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void exit(ActionEvent event){
        System.exit(1);
    }
}
