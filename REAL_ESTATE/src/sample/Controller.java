package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class Controller {
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


}