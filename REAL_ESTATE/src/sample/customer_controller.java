package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customer_controller {
    private Stage stage = new Stage();
    Stage stg1 = new Stage();
    @FXML
    Button btn_show = new Button();
    @FXML
    Button btn_shw = new Button();
    @FXML
    TextField txt_info_estate = new TextField();
    @FXML
    Button btn_filter = new Button();
    @FXML
    private TableColumn<customer_details,String> username;
    @FXML
    private TableColumn<customer_details,String> estate_id;
    @FXML
    private TableColumn<customer_details,String> category;

    @FXML
    private TableColumn<customer_details,String> type;

    @FXML
    private TableColumn<customer_details,String> adress;

    @FXML
    private TableColumn<customer_details,String> price;
    @FXML
    private TableColumn<customer_details,String> num_of_rooms;
    @FXML
    private TableColumn<customer_details,String> size;

    @FXML
    private TableColumn<estate_info_details,String>username3;
    @FXML
    private TableColumn<estate_info_details,String>name3;
     @FXML
     private TableColumn<estate_info_details,String>surname3;
     @FXML
     private TableColumn<estate_info_details,String>phone_number3;
      @FXML
      private TableColumn<estate_info_details,String>email3;
      @FXML
      private TableView<estate_info_details>TableProfile5;
     @FXML
    TextField txt_ctg = new  TextField();
    @FXML
    TextField txt_adr = new  TextField();
    @FXML
    TextField txt_typ = new  TextField();
    @FXML
    private TableView<customer_details> TableProfile3;

    public ObservableList<customer_details> data;
    public ObservableList<estate_info_details> data1;

    public void back(ActionEvent event) throws IOException
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("login.fxml"))  ;
        Scene scn = new Scene(p1);
        stg1.setTitle("main menu");
        stg1.setScene(scn);
        stg1.show();

    }

    public void ShowAllEstate(ActionEvent event)
    {
        connection.conn connectionClass = new connection.conn();
        Connection conn = connectionClass.Connect();


        try {



            data = FXCollections.observableArrayList();
            // Execute query
            ResultSet resultSet = conn.createStatement().executeQuery("select * from estate1 ");

            while(resultSet.next())
            {
                //get string from db
                data.add(new customer_details(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        // Set cell value factory to Table view
        // NB.PropertyValue Factory must be same with the one set in model class.
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        estate_id.setCellValueFactory(new PropertyValueFactory<>("estate_id"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        num_of_rooms.setCellValueFactory(new PropertyValueFactory<>("num_of_rooms"));
        size.setCellValueFactory(new PropertyValueFactory<>("size"));





        TableProfile3.setItems(null);
        TableProfile3.setItems(data);
    }

    public void FilterEstate(ActionEvent event){




        String query="{call make_filter (?,?,?)}";
        ResultSet resultSet;
        try{
            data = FXCollections.observableArrayList();
            connection.conn connectionClass = new connection.conn();
            Connection conn = connectionClass.Connect();
            CallableStatement stmt=conn.prepareCall(query);
            stmt.setString(1,txt_ctg.getText());
            stmt.setString(2,txt_adr.getText());
            stmt.setString(3,txt_typ.getText());


            resultSet=stmt.executeQuery();
            while(resultSet.next())
            {
                data.add(new customer_details(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));

            }

        }
        catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        estate_id.setCellValueFactory(new PropertyValueFactory<>("estate_id"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        num_of_rooms.setCellValueFactory(new PropertyValueFactory<>("num_of_rooms"));
        size.setCellValueFactory(new PropertyValueFactory<>("size"));

        TableProfile3.setItems(null);
        TableProfile3.setItems(data);

    }

    public void ShowEstateInfo(ActionEvent event)       throws  SQLException
    {
                 connection.conn connectionClass = new connection.conn();
                 Connection conn = connectionClass.Connect();


        try {




            data1 = FXCollections.observableArrayList();
            // Execute query
            ResultSet resultSet = conn.createStatement().executeQuery("select * from estate_info where username3='"+txt_info_estate.getText()+"'");

            while(resultSet.next())
            {
                //get string from db
                data1.add(new estate_info_details(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        // Set cell value factory to Table view
        // NB.PropertyValue Factory must be same with the one set in model class.
        username3.setCellValueFactory(new PropertyValueFactory<>("username3"));
        name3.setCellValueFactory(new PropertyValueFactory<>("name3"));
        surname3.setCellValueFactory(new PropertyValueFactory<>("surname3"));
        phone_number3.setCellValueFactory(new PropertyValueFactory<>("phone_number3"));
        email3.setCellValueFactory(new PropertyValueFactory<>("email3"));

        TableProfile5.setItems(null);
        TableProfile5.setItems(data1);
    }


}

