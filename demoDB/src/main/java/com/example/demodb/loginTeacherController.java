package com.example.demodb;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class loginTeacherController implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField username;
    @FXML
    private Label wrong;
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @FXML
    private Label myLabel;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler = new DBHandler();
    }

    public void login(ActionEvent event) throws IOException {
        connection=handler.getConnection();
        String query=" Select * from listteachers where firstName=?";
        try {
            String prenom = "";
            String nom ="";
            String cin ="";
            String matiere = "";
            String id = "";
            String city = "";
            pst = connection.prepareStatement(query);
            pst.setString(1, username.getText());
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while (rs.next()) {
                prenom = rs.getString("firstName");
                nom =rs.getString("lastName");
                cin= rs.getString("cin");
                matiere = rs.getString("matiere");
                id= rs.getString("id");
                city = rs.getString("city");
                count++;
            }
            if (count > 0 && password.getText().equals("admin")){
                profilTeacherController.infos = new String[]{prenom + " " + nom,city,matiere,cin,id};
                FXMLLoader loader = new FXMLLoader(getClass().getResource("profilTeacher.fxml"));
                root = loader.load();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setResizable(false); // this is to prevent the user from resizing the window
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
            else
                wrong.setText("Invalid username or password");
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

    public void backToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void signup(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signUpTeacher.fxml"));
        root = loader.load();
        // root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit() {
        System.exit(0);
    }


}
