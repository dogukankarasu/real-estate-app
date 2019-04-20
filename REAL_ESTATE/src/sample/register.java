package sample;

import connection.conn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class register {
    public conn dc;
    private Stage stage = new Stage();
    Stage stg1 = new Stage();

    /*public TextField name;
    public TextField surname;
    public TextField username;
    public TextField password;

    public TextField  email;*/

    @FXML
    TextField name = new TextField();
    @FXML
    TextField surname = new TextField();
    @FXML
    TextField username = new TextField();
    @FXML
    TextField password = new TextField();
    @FXML
    TextField email = new TextField();
    @FXML
    TextField phone = new TextField();

    @FXML
    Button btnRegister= new Button();



    public void InsertUser(ActionEvent event) throws SQLException
    {
        Connection conn = dc.Connect();



        Random rand = new Random();

        int user_id = rand.nextInt(10000);

        if(username.getText().isEmpty() || name.getText().isEmpty() || surname.getText().isEmpty() || password.getText().isEmpty() )
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Error occurred!");
            alert.setContentText("Please enter all necessary information!");

            alert.showAndWait();
        }
        else
        {
            String sql = "INSERT INTO register1 VALUES('"+user_id+"','"+name.getText()+"','"+surname.getText()+"','"
                    +username.getText()+"','"+password.getText()+"','"+email.getText()+"','"+phone.getText()+"')";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

            String sql2 = "INSERT INTO estate_info VALUES('"+username.getText()+"','"+name.getText()+"','"+surname.getText()+"','"+phone.getText()+"','"+email.getText()+"')";
            Statement statement2 = conn.createStatement();
            statement2.executeUpdate(sql2);



            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("You have successfully signed in!");
            alert.setContentText(" Please click to button for continue .");

            alert.showAndWait();


        }

    }

    public void next3(ActionEvent event) throws IOException
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("../sample/entry.fxml"));
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

}


