package com.company;

import java.util.*;

public class Job {
    private int jobNumber;
    private Address location;
    private String description;
    private List<Equipment> requiredEquipment;
    private Date plannedDate;
    static int jobTotal = 0;
    public Job(Address location, String description, List<Equipment> requiredEquipment, Date plannedDate)
    {
        this.location=location;
        this.description=description;
        this.requiredEquipment=requiredEquipment;
        this.plannedDate=plannedDate;
        jobTotal++;
        this.jobNumber=jobTotal;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public static int getJobTotal() {
        return jobTotal;
    }

    public Address getLocation() {
        return location;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public List<Equipment> getRequiredEquipment() {
        return requiredEquipment;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        String res="";
        res+="Job: "+this.jobNumber+" "+ this.location.toString()+", Description: "+this.description+", Required Equipment:";
        for(int i=0;i<this.requiredEquipment.size();i++)
            res+=" "+this.requiredEquipment.get(i).toString();
        res+=", Planned date: "+ plannedDate.toString();
        return res;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof Job) {
            Job that = (Job ) o;
            return this.jobNumber==that.jobNumber && this.location.equals(that.location) && this.description.equals(that.description) && this.requiredEquipment.equals(that.requiredEquipment) && this.plannedDate.equals(that.plannedDate);
        }
        return false;
    }


}
