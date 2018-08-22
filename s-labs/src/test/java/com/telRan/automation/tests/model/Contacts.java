package com.telRan.automation.tests.model;

public class Contacts {
    private  String firstName;
    private  String lastName;
    private  String address;
    private String homePhone;





    public String getHomePhone() {return homePhone;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contacts withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Contacts withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contacts withAddress(String address) {
        this.address = address;
        return this;
    }

    public Contacts withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getAddress() {
        return address;
    }
}
