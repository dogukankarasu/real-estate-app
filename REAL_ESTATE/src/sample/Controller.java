package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import connection.conn;

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
    public TextField username1 = new TextField();
    public PasswordField password1 = new PasswordField();
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
        Parent p1 = FXMLLoader.load(getClass().getResource("admin_entry.fxml"))  ;
        Scene scn1 = new Scene(p1);
        stg1.setTitle("admin entry");
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
    private TableView<user_details> TableProfile7;
    public ObservableList<user_details> data3;

    public void ShowDeleted(ActionEvent event)
    {
        connection.conn connectionClass = new connection.conn();
        Connection conn = connectionClass.Connect();


        try {



            data3 = FXCollections.observableArrayList();
            // Execute query
            ResultSet resultSet = conn.createStatement().executeQuery("select * from register1_history ");

            while(resultSet.next())
            {
                //get string from db
                data3.add(new user_details(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)));
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

        TableProfile7.setItems(null);
        TableProfile7.setItems(data3);
    }
    public void enter_admin(ActionEvent event)throws IOException
    {

        if(username1.getText().isEmpty() || password1.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Empty Fields!");
            alert.setContentText("Please enter all necessary information!");

            alert.showAndWait();
        }
        else if(username1.getText().equals("admin")&& password1.getText().equals("1234"))
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Parent p1 = FXMLLoader.load(getClass().getResource("admin.fxml"))  ;
            Scene scn = new Scene(p1);
            stg1.setTitle("main menu");
            stg1.setScene(scn);
            stg1.show();

        }

    }



}