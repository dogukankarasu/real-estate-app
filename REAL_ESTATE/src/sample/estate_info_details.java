package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class estate_info_details {

    private final StringProperty username3;
    private final StringProperty name3;
    private final StringProperty surname3;
    private final StringProperty phone_number3;
    private final StringProperty email3;


    //Constructor

    public estate_info_details(String username3, String name3, String surname3, String phone_number3,  String email3) {

        this.username3 =new SimpleStringProperty(username3) ;
        this.name3 = new SimpleStringProperty(name3);
        this.surname3 = new SimpleStringProperty(surname3);
        this.phone_number3 = new SimpleStringProperty(phone_number3);
        this.email3 = new SimpleStringProperty(email3);



    }

    // Getters
    public String getusername3()
    {
        return username3.get();
    }
    public String getname3()
    {
        return name3.get();
    }
    public String getsurname3()
    {
        return surname3.get();
    }

    public String getphone_number3()
    {
        return phone_number3.get();
    }

    public String getemail3()
    {
        return email3.get();
    }

    //Setters

    public void setusername3(String value)
    {
        username3.set(value);
    }
    public void setname3(String value)
    {
        name3.set(value);
    }
    public void setsurname3(String value)
    {
        surname3.set(value);
    }

    public void setphone_number3(String value)
    {
        phone_number3.set(value);
    }
    public void setemail3(String value)
    {
        email3.set(value);
    }

    //property values
    public StringProperty username3Property()
    {
        return username3;
    }
    public StringProperty name3Property()
    {
        return name3;
    }
    public StringProperty surname3Property()
    {
        return surname3;
    }

    public StringProperty phone_number3Property()
    {
        return phone_number3;
    }
    public StringProperty email3Property()
    {
        return email3;
    }

}


