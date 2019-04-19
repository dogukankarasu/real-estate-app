package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class customer_details {

    private final StringProperty username;
    private final StringProperty estate_id;
    private final StringProperty category_est;
    private final StringProperty type_est;
    private final StringProperty adress;
    private final StringProperty price;
    private final StringProperty num_of_rooms;
    private final StringProperty size_est;


    //Constructor

    public customer_details(String username, String estate_id , String category, String type, String adress, String price, String num_of_rooms, String size) {

        this.username =new SimpleStringProperty(username);
        this.estate_id = new SimpleStringProperty(estate_id);
        this.category_est = new SimpleStringProperty(category);
        this.type_est =new SimpleStringProperty(type) ;
        this.adress = new SimpleStringProperty(adress);
        this.price= new SimpleStringProperty(price);
        this.num_of_rooms = new SimpleStringProperty(num_of_rooms);
        this.size_est = new SimpleStringProperty(size);
    }

    // Getters
    public String getusername()
    {
        return username.get();
    }
    public String getestate_id()
    {
        return estate_id.get();
    }
    public String getcategory()
    {
        return category_est.get();
    }
    public String gettype()
    {
        return type_est.get();
    }
    public String getadress()
    {
        return adress.get();
    }
    public String getprice()
    {
        return price.get();
    }
    public String getnum_of_rooms()
    {
        return num_of_rooms.get();
    }
    public String getsize()
    {
        return size_est.get();
    }

    //Setters

    public void setusername(String value)
    {
        username.set(value);
    }
    public void setEstate_id(String value)
    {
        estate_id.set(value);
    }
    public void setcategory(String value)
    {
        category_est.set(value);
    }
    public void settype(String value)
    {
        type_est.set(value);
    }
    public void setadress(String value)
    {
        adress.set(value);
    }
    public void setprice(String value)
    {
        price.set(value);
    }
    public void setnum_of_rooms(String value)
    {
        num_of_rooms.set(value);
    }
    public void setsize(String value)
    {
        size_est.set(value);
    }
    //property values
    public StringProperty usernameProperty()
    {
        return username;
    }
    public StringProperty estate_idProperty()
    {
        return estate_id;
    }
    public StringProperty categoryProperty()
    {
        return category_est;
    }
    public StringProperty typeProperty()
    {
        return type_est;
    }
    public StringProperty adressProperty()
    {
        return adress;
    }
    public StringProperty priceProperty()
    {
        return price;
    }
    public StringProperty num_of_roomsProperty()
    {
        return num_of_rooms;
    }
    public StringProperty sizeProperty()
    {
        return size_est;
    }
}

