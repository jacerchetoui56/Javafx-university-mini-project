package com.example.demodb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.ResourceBundle;

public class profilStudentController  {
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
    private ImageView infosImg;

    public static String[] infos ;

    public void displayInfos(ActionEvent event) throws IOException{
        System.out.println("clicked");
        fullName.setText(infos[0]);
        groupField.setText(infos[1]);
        cinField.setText(infos[2]);
        idField.setText(infos[3]);
        infosBtn.setStyle("-fx-text-fill : blue; -fx-background-color : #eaf2ff ; -fx-background-radius: 13;");
    }
    public void logout(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signInStudent.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showTable(ActionEvent event) throws IOException{
        if(infos[1].equals("Group1")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeTable1.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false); // this is to prevent the user from resizing the window
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(infos[1].equals("Group2")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeTable2.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false); // this is to prevent the user from resizing the window
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(infos[1].equals("Group3")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeTable3.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false); // this is to prevent the user from resizing the window
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(infos[1].equals("Group4")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeTable4.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false); // this is to prevent the user from resizing the window
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToInfos(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profilStudent.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showTableList(ActionEvent event) throws IOException{
        listController.groupeList = infos[1];
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listGroup.fxml"));
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
