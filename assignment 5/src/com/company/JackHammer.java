package com.company;
import java.util.*;
public class JackHammer extends Equipment implements PowerSupply{
    @Override
    public String getPowerSupply() {
        return "Air Compressor";
    }

    public JackHammer(String requirements)
    {
        super(requirements);    }

    @Override
    public String getRequirements() {
        return super.getRequirements();
    }
    public String toString()
    {
        return "Jack Hammer: "+getRequirements()+ " Needs: "+ getPowerSupply()+",";
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof JackHammer)
        {
            JackHammer that = (JackHammer) obj;
            return that.getRequirements().equals(this.getRequirements());
        }
        return false;
    }
}