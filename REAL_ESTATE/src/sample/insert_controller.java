package sample;

import connection.conn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class insert_controller {
    public conn dc;

    private Stage stage = new Stage();
    Stage stg1 = new Stage();
    @FXML
    Label lbl_insrt = new Label();
    @FXML
    Label lbl_ntc = new Label();

    public void backUser2(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("user_screen.fxml"));
        Parent p1 = loader.load();
        user_control thirdController = loader.getController();
        thirdController.setLblPass(lbl_ntc.getText());
        Scene scn = new Scene(p1);

        stg1.setTitle("USER");
        stg1.setScene(scn);
        stg1.show();
    }
    public void gotoinsertnotice(String text){

        lbl_insrt.setText(text);
    }


    @FXML
    TextField text_ctg = new TextField();
    @FXML
    TextField text_typ = new TextField();
    @FXML
    TextField text_adr = new TextField();
    @FXML
    TextField text_prc = new TextField();
    @FXML
    TextField text_rm = new TextField();
    @FXML
    TextField text_sz = new TextField();

    @FXML
    Button btnInsert= new Button();



    public void InsertState(ActionEvent event) throws SQLException
    {
        Connection conn = dc.Connect();



        Random rand = new Random();

        int estate_id = rand.nextInt(10000);




            String sql = "INSERT INTO estate1 VALUES('"+lbl_insrt.getText()+"','"+estate_id+"','"+text_ctg.getText()+"','"+text_typ.getText()+"','"
                    +text_adr.getText()+"','"+text_prc.getText()+"','"+text_rm.getText()+"','"+text_sz.getText()+"')";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("You have successfully signed in!");
            alert.setContentText(" Please click to button for continue .");

            alert.showAndWait();

    }
    public void gotouserscreen(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("user_screen.fxml"));
        Parent p1 = loader.load();
        user_control thirdController = loader.getController();
        thirdController.gotouserscreen(lbl_insrt.getText());


        Scene scn1 = new Scene(p1);
        stg1.setTitle("notices");
        stg1.setScene(scn1);
        stg1.show();

    }

}
