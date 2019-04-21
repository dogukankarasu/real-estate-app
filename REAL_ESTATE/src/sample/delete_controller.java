package sample;

import connection.conn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class delete_controller {
    public connection.conn dc;
    Connection conn = dc.Connect();
    private Stage stage = new Stage();
    Stage stg1 = new Stage();

    @FXML
    Label lbl_dlt = new Label();
    @FXML
    TextField text_delete = new TextField();

    public void backUser(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("user_screen.fxml"));
        Scene scn = new Scene(p1);
        stg1.setTitle("USER");
        stg1.setScene(scn);
        stg1.show();

    }
    public void gotodeletenotice(String text){

        lbl_dlt.setText(text);
    }
    public void gotouserscreen(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("user_screen.fxml"));
        Parent p1 = loader.load();
        user_control thirdController = loader.getController();
        thirdController.gotouserscreen(lbl_dlt.getText());


        Scene scn1 = new Scene(p1);
        stg1.setTitle("notices");
        stg1.setScene(scn1);
        stg1.show();

    }

    public void DeleteEstate(ActionEvent event) throws SQLException
    {
        Connection conn = dc.Connect();


        String sql = "DELETE FROM  estate1 WHERE username='"+lbl_dlt.getText()+"' and estate_id='"+text_delete.getText()+"'";
        Statement statement = conn.createStatement();
        statement.execute(sql);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("Successfully Deleted!");
        alert.setContentText(" Please click to button for continue .");

        alert.showAndWait();




    }
}
