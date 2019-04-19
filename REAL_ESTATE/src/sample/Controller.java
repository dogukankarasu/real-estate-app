package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import connection.conn;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import sun.security.util.Password;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private conn dc;

    public Label isConnected = new Label();
    public TextField Username = new TextField();
    public PasswordField Password = new PasswordField();
    private Stage stage = new Stage();
    Stage stg1 = new Stage();
    @FXML
    Button cstmr_btn= new Button();
    @FXML
    Button real_btn= new Button();
    @FXML
    Button bck_btn= new Button();
    @FXML
    Button bck2_btn= new Button();
    @FXML
    Button bck3_btn= new Button();
    @FXML
    Button sign_btn= new Button();
    @FXML
    Button lgn_btn= new Button();
    public void next(ActionEvent event) throws IOException
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("customer.fxml"))  ;
        Scene scn1 = new Scene(p1);
        stg1.setTitle("customer");
        stg1.setScene(scn1);
        stg1.show();

    }
    public void next2(ActionEvent event) throws IOException
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("sign_up.fxml"))  ;
        Scene scn1 = new Scene(p1);
        stg1.setTitle("sign up");
        stg1.setScene(scn1);
        stg1.show();

    }
    public void next3(ActionEvent event) throws IOException
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("entry.fxml"))  ;
        Scene scn1 = new Scene(p1);
        stg1.setTitle("entry");
        stg1.setScene(scn1);
        stg1.show();

    }
    public void back(ActionEvent event) throws IOException
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("login.fxml"))  ;
        Scene scn = new Scene(p1);
        stg1.setTitle("main menu");
        stg1.setScene(scn);
        stg1.show();

    }


    /*
    public void Login(ActionEvent event) throws IOException{

        if(Username.getText().isEmpty() || Password.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Empty Fields!");
            alert.setContentText("Please enter all necessary information!");

            alert.showAndWait();
        }

        connection.conn connectionClass = new connection.conn();
        Connection connection = connectionClass.Connect();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM register1 WHERE username = '" + Username.getText() + "' AND password = '" + Password.getText() + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next())
            {
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent p1 = FXMLLoader.load(getClass().getResource("user_screen.fxml"));
                Scene scnSignin = new Scene(p1);

                stage.setTitle("User Screen");
                stage.setScene(scnSignin);
                stage.show();

            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Login Failed!");
                alert.setContentText("Please check your username or password!");

                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lgn_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                FXMLLoader loader=new FXMLLoader(getClass().getResource("user_screen.fxml"));


                try {
                    Parent root=loader.load();
                    user_control secondController=loader.getController();
                    secondController.setLblPass(Username.getText());


                    if(Username.getText().isEmpty() || Password.getText().isEmpty())
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("");
                        alert.setHeaderText("Empty Fields!");
                        alert.setContentText("Please enter all necessary information!");

                        alert.showAndWait();
                    }

                    connection.conn connectionClass = new connection.conn();
                    Connection connection = connectionClass.Connect();
                    try {
                        Statement statement = connection.createStatement();
                        String sql = "SELECT * FROM register1 WHERE username = '" + Username.getText() + "' AND password = '" + Password.getText() + "'";
                        ResultSet resultSet = statement.executeQuery(sql);

                        if (resultSet.next())
                        {
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                            Parent p1 = FXMLLoader.load(getClass().getResource("user_screen.fxml"));


                            stage.setTitle("User Screen");
                            Scene scene=new Scene(root);
                            stage.setScene(scene);
                            stage.show();

                        }
                        else
                        {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("Login Failed!");
                            alert.setContentText("Please check your username or password!");

                            alert.showAndWait();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

    }



}