package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class user_details {
    private final StringProperty user_id;
    private final StringProperty name;
    private final StringProperty surname;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty email;
    private final StringProperty phone_number;

    //Constructor

    public user_details(String user_id, String name, String surname, String username, String password, String email, String phone_number) {

        this.user_id =new SimpleStringProperty(user_id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.username =new SimpleStringProperty(username) ;
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.phone_number = new SimpleStringProperty(phone_number);
    }

    // Getters
    public String getuser_id()
    {
        return user_id.get();
    }
    public String getname()
    {
        return name.get();
    }
    public String getsurname()
    {
        return surname.get();
    }
    public String getusername()
    {
        return username.get();
    }
    public String getpassword()
    {
        return password.get();
    }
    public String getemail()
    {
        return email.get();
    }
    public String getphone_number()
    {
        return phone_number.get();
    }

    //Setters

    public void setuser_id(String value)
    {
        user_id.set(value);
    }
    public void setname(String value)
    {
        name.set(value);
    }
    public void setsurname(String value)
    {
        surname.set(value);
    }
    public void setusername(String value)
    {
        username.set(value);
    }
    public void setpassword(String value)
    {
        password.set(value);
    }
    public void setemail(String value)
    {
        email.set(value);
    }
    public void setphone_number(String value)
    {
        phone_number.set(value);
    }
    //property values
    public StringProperty user_idProperty()
    {
        return user_id;
    }
    public StringProperty nameProperty()
    {
        return name;
    }
    public StringProperty surnameProperty()
    {
        return surname;
    }
    public StringProperty usernameProperty()
    {
        return username;
    }
    public StringProperty passwordProperty()
    {
        return password;
    }
    public StringProperty emailProperty()
    {
        return email;
    }
    public StringProperty phone_numberProperty()
    {
        return phone_number;
    }
}


