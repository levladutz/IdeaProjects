package com.company;
import java.util.*;
public class ScaffoldingTower extends Equipment{
    public ScaffoldingTower(String requirements)
    {
        super(requirements);
    }
    @Override
    public String getRequirements() {
        return super.getRequirements();
    }
    public String toString()
    {
        return "Scaffolding Tower: "+getRequirements();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ScaffoldingTower)
        {
            ScaffoldingTower that = (ScaffoldingTower) obj;
            return that.getRequirements().equals(this.getRequirements());
        }
        return false;
    }
}