package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class notice_controller {

    @FXML
    Button dlt_btn = new Button();
    @FXML
    Button insrt_btn = new Button();
    @FXML
    Button upd_btn = new Button();
    @FXML
    Label lbl_ntc = new Label();
@FXML
public Label lbl_insrt;
    @FXML
    private TableColumn<notice_details,String> username;
    @FXML
    private TableColumn<notice_details,String> estate_id;
    @FXML
    private TableColumn<notice_details,String> category;

    @FXML
    private TableColumn<notice_details,String> type;

    @FXML
    private TableColumn<notice_details,String> adress;

    @FXML
    private TableColumn<notice_details,String> price;
    @FXML
    private TableColumn<notice_details,String> num_of_rooms;
    @FXML
    private TableColumn<notice_details,String> size;
    @FXML
    private TableView<notice_details> TableProfile2;
    public ObservableList<notice_details> data;
    private Stage stage = new Stage();
    Stage stg1 = new Stage();
    public void nextInsert(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("insert_notice.fxml"));
        Parent p1 = loader.load();
        insert_controller thirdController = loader.getController();
        thirdController.gotoinsertnotice(lbl_ntc.getText());


        Scene scn1 = new Scene(p1);
        stg1.setTitle("INSERT");
        stg1.setScene(scn1);
        stg1.show();

    }
    public void nextUpdate(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("update_notice.fxml"));
        Parent p1 = loader.load();
        update_controller thirdController = loader.getController();
        thirdController.gotoupdatenotice(lbl_ntc.getText());


        Scene scn1 = new Scene(p1);
        stg1.setTitle("UPDATE");
        stg1.setScene(scn1);
        stg1.show();

    }
    public void nextDelete(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("delete_notice.fxml"));
        Parent p1 = loader.load();
        delete_controller thirdController = loader.getController();
        thirdController.gotodeletenotice(lbl_ntc.getText());



        Scene scn1 = new Scene(p1);
        stg1.setTitle("DELETE");
        stg1.setScene(scn1);
        stg1.show();

    }
    public void backUser(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("user_screen.fxml"));
        Parent p2 = loader.load();
        user_control thirdController = loader.getController();
        thirdController.setLblPass(lbl_ntc.getText());
        Scene scn = new Scene(p2);

        stg1.setTitle("USER");
        stg1.setScene(scn);
        stg1.show();

    }

    public void gotousernotice(String text){

        lbl_ntc.setText(text);
    }

    public void ShowMyEstate(ActionEvent event)
    {
        connection.conn connectionClass = new connection.conn();
        Connection conn = connectionClass.Connect();


        try {



            data = FXCollections.observableArrayList();
            // Execute query
            ResultSet resultSet = conn.createStatement().executeQuery("select * from estate1 where username='"+lbl_ntc.getText()+"'");

            while(resultSet.next())
            {
                //get string from db
                data.add(new notice_details(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
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





        TableProfile2.setItems(null);
        TableProfile2.setItems(data);
    }


}
