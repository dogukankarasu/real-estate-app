package sample;

import com.mysql.cj.Query;
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
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class update_controller {

    public conn dc;
    Connection conn = dc.Connect();
    private Stage stage = new Stage();
    Stage stg1 = new Stage();






    @FXML
    TextField txt_id = new TextField();
    @FXML
    TextField txt_ctg = new TextField();
    @FXML
    TextField txt_adr = new TextField();
    @FXML
    TextField txt_prc = new TextField();
    @FXML
    TextField txt_rm = new TextField();
    @FXML
    TextField txt_sz = new TextField();
    @FXML
    TextField txt_typ = new TextField();
    @FXML
    Button btn_save = new Button();
    @FXML
    Label lbl_updt = new Label();



  /*  public void backUser(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("user_screen.fxml"));
        Scene scn = new Scene(p1);
        stg1.setTitle("USER");
        stg1.setScene(scn);
        stg1.show();

    }*/

    public void gotoupdatenotice(String text) {

        lbl_updt.setText(text);
    }

    public void update_notice(ActionEvent event) throws SQLException {

        if (txt_id.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Error occurred!");
            alert.setContentText("Please enter all necessary information!");

            alert.showAndWait();
        } else {


            Statement statement = conn.createStatement();
            String sql = "UPDATE estate1 SET category_est='"+txt_ctg.getText()+"', type_est='"+txt_typ.getText()+"', adress='"+txt_adr.getText()+"', price='"+txt_prc.getText()+"', num_of_rooms='"+txt_rm.getText()+"', size_est='"+txt_sz.getText()+"' WHERE username='"+lbl_updt.getText()+"' and estate_id='"+txt_id.getText()+"'";
            statement.executeUpdate(sql);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Your information has been updated!");
            alert.showAndWait();
        }
    }

    public void gotouserscreen(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("user_screen.fxml"));
        Parent p1 = loader.load();
        user_control thirdController = loader.getController();
        thirdController.gotouserscreen(lbl_updt.getText());


        Scene scn1 = new Scene(p1);
        stg1.setTitle("notices");
        stg1.setScene(scn1);
        stg1.show();

    }

    PreparedStatement pst=null;
    ResultSet rs=null;
    public void LoadEstate(ActionEvent event) {


        try {
            String sql = "SELECT category_est,type_est,adress,price,num_of_rooms,size_est FROM estate1 WHERE estate_id ='"+txt_id.getText()+"'";
            pst=conn.prepareStatement(sql);


            rs = pst.executeQuery();
            if(rs.next()) {
                String category = rs.getString("category_est");
                txt_ctg.setText(category);

                String type = rs.getString("type_est");
                txt_typ.setText(type);

                String adress = rs.getString("adress");
                txt_adr.setText(adress);

                String price = rs.getString("price");
                txt_prc.setText(price);

                String room = rs.getString("num_of_rooms");
                txt_rm.setText(room);

                String size = rs.getString("size_est");
                txt_sz.setText(size);

            }
        } catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
}
