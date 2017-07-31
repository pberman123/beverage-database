package com.makingstuffhappen.bevDB.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by philip on 6/14/17. This is the Beverage Entity
 */
@Entity
public class Beverage {

    //This defines the unique id to be stored as primary key in the database
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    //These are the other attributes of the class
    private String bevType;
    private String name;
    private String year;
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBevType() {
        return bevType;
    }

    public void setBevType(String bevType) {
        this.bevType = bevType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //default constructor
    public Beverage() {
        super();
    }

    //constructor
    public Beverage(String p_bevType, String p_name, String p_year, String p_location) {
        super();
        this.setBevType(p_bevType);
        this.setName(p_name);
        this.setYear(p_year);
        this.setLocation(p_location);
    }

    @Override
    public String toString() {
        return "Beverage[ id = " + id + ",Beverage Name is = " + name + " ]";
    }


}
