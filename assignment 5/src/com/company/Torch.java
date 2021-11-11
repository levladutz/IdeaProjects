package com.company;
import java.util.*;
public class Torch extends Equipment implements PowerSupply{
    @Override
    public String getPowerSupply() {
        return "Butane Gas";
    }

    public Torch(String requirements)
    {
        super(requirements);
    }

    @Override
    public String getRequirements() {
        return super.getRequirements();
    }
    public String toString()
    {
        return "Torch: "+getRequirements()+ " Needs: "+ getPowerSupply()+",";
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Torch)
        {
            Torch that = (Torch) obj;
            return that.getRequirements().equals(this.getRequirements());
        }
        return false;
    }
}