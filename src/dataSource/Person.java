/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

/**
 *
 * @author Alex-Store
 */
public class Person {
    int id;
    String fName;
    String lName;
    String mName;
    String email;
    int phone;

    public Person() {
        this.id = 0;
        this.fName = "";
        this.lName = "";
        this.mName = "";
        this.email = "";
        this.phone = 0;
    }

    public Person(int id, String fName, String lName, String mName, String email, int phone) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.mName = mName;
        this.email = email;
        this.phone = phone;
    }

    public Person(String fName, String lName, String mName, String email, int phone) {
        this.fName = fName;
        this.lName = lName;
        this.mName = mName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getmName() {
        return mName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    


}
