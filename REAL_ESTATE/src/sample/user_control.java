package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class user_control implements Initializable {
    public connection.conn dc;
    Connection conn = dc.Connect();

    @FXML
    Button bck4_btn = new Button();
    @FXML
    Button ntc_btn = new Button();
    @FXML
    Button dlt_btn = new Button();
    @FXML
    Button insrt_btn = new Button();
    @FXML
    Button upd_btn = new Button();
    @FXML
    Button prfl_btn = new Button();
    @FXML
    Button dltact_btn = new Button();

    @FXML
    public Button gotouserscreen;
    @FXML
    private TableColumn<user_details,String> user_id;
    @FXML
    private TableColumn<user_details,String> name;
    @FXML
    private TableColumn<user_details,String> surname;

    @FXML
    private TableColumn<user_details,String> password;

    @FXML
    private TableColumn<user_details,String> email;

    @FXML
    private TableColumn<user_details,String> username;
    @FXML
    private TableColumn<user_details,String> phone_number;
    @FXML
    private TableView<user_details> TableProfile;
    @FXML
    public Label lbl_ntc;

    private Stage stage = new Stage();
    Stage stg1 = new Stage();

    public ObservableList<user_details> data;




    public void ShowMyInformation(ActionEvent event)
    {
        connection.conn connectionClass = new connection.conn();
        Connection conn = connectionClass.Connect();


        try {



            data = FXCollections.observableArrayList();
            // Execute query
            ResultSet resultSet = conn.createStatement().executeQuery("select * from register1 where username='"+lbl_user.getText()+"'");

            while(resultSet.next())
            {
                //get string from db
                data.add(new user_details(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        // Set cell value factory to Table view
        // NB.PropertyValue Factory must be same with the one set in model class.
        user_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));





        TableProfile.setItems(null);
        TableProfile.setItems(data);
    }






    public void back2(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scn = new Scene(p1);
        stg1.setTitle("main menu");
        stg1.setScene(scn);
        stg1.show();

    }
    public void nextUser(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("user_notice.fxml"));
        Parent p1 = loader.load();
        notice_controller thirdController = loader.getController();
        thirdController.gotousernotice(lbl_user.getText());


        Scene scn1 = new Scene(p1);
        stg1.setTitle("notices");
        stg1.setScene(scn1);
        stg1.show();

    }
    public void DeleteAccount(ActionEvent event) throws SQLException , IOException
    {
        Connection conn = dc.Connect();


        String sql = "DELETE FROM  register1 WHERE username='"+lbl_user.getText()+"' ";
        Statement statement = conn.createStatement();
        statement.execute(sql);
        String sql1 = "DELETE FROM  estate1 WHERE username='"+lbl_user.getText()+"' ";
        Statement statement1 = conn.createStatement();
        statement1.execute(sql1);

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scn = new Scene(p1);
        stg1.setTitle("main menu");
        stg1.setScene(scn);
        stg1.show();


    }

    @FXML
    Label lbl_user;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setLblPass(String text){

        lbl_user.setText(text);
    }

    public void gotouserscreen(String text){

        lbl_user.setText(text);
    }



}
