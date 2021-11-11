package com.company;
import java.util.*;
public class Address {
    private String street;
    private int number;
    private String zipCode;
    private String city;

    public Address(String street, int number, String zipCode, String city){
        this.number=number;
        this.street=street;
        this.zipCode=zipCode;
        this.city=city;
    }
    public String getStreet(){
        return this.street;
    }
    public int getNumber(){
        return this.getNumber();
    }
    public String getZipCode(){
        return this.zipCode;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Address: street-"+this.street+" number-"+this.number+" zipCode-"+this.zipCode+" city-"+this.city;
    }
    public boolean equals(Object object)
    {
        if(object instanceof Address)
        {
            Address that = (Address) object;
            if(that.zipCode.equals(this.zipCode))
                return true;
        }
        return false;
    }
}
