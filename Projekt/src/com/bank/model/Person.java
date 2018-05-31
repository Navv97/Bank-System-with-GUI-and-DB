package com.bank.model;

import java.sql.Timestamp;

public class Person {
    private int personID;
    private String personName;
    private String personSurname;
    private Address personAddress;
    private String personPesel;

    public Person(String personName, String personSurname, Address personAddress, String personPesel) {
        this.personID = generateClientID();
        this.personName = personName;
        this.personSurname = personSurname;
        this.personAddress = personAddress;
        this.personPesel = personPesel;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    public Address getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(Address personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonPesel() {
        return personPesel;
    }

    public void setPersonPesel(String personPesel) {
        this.personPesel = personPesel;
    }

    public String stringForSQLQuery(){
        return "'" + personName + "'" + ',' + "'" + personSurname+ "'" + ',' + personAddress.addressForSQLQuery() + "'" + personPesel + "'";
    }

    public int generateClientID(){
        Timestamp clientID = new Timestamp(System.currentTimeMillis());
        return clientID.getNanos()/1000;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personSurname='" + personSurname + '\'' +
                ", personAddress=" + personAddress +
                ", personPesel='" + personPesel + '\'' +
                '}';
    }
}
