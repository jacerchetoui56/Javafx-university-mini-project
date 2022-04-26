package com.example.demodb;

import com.example.demodb.DBConnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class listTeacherController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;


    public static String whichList;

    @FXML
    private ListView<String> listOfgroup;


    public void showList1(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("groupList1.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showList2(ActionEvent event) throws IOException{
        whichList = "Group2";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("groupList2.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showList3(ActionEvent event) throws IOException{
        whichList = "Group3";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("groupList3.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showList4(ActionEvent event) throws IOException{
        whichList = "Group4";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("groupList4.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showTimeTable(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeTableForTeacher1.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    public void exit(ActionEvent event) throws IOException{
        System.exit(1);
    }
    public void switchToInfos(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profilTeacher.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false); // this is to prevent the user from resizing the window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler = new DBHandler();
        connection=handler.getConnection();
        String query=" Select * from liste where id>0";
        try {
            pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while (rs.next()) {
                if(rs.getString("classe").equals(whichList)) listOfgroup.getItems().add("             "+rs.getString("id")
                        +"                             "+
                        rs.getString("firstName")+
                      " "+
                        rs.getString("lastName"));
                count++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
