package com.company;

import java.util.*;
public class ConcreteMixer extends Equipment{
    public ConcreteMixer(String requirements)
    {
        super(requirements);    }
    @Override
    public String getRequirements() {
        return super.getRequirements();
    }
    public String toString()
    {
        return "Concrete Mixer: "+getRequirements();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ConcreteMixer)
        {
            ConcreteMixer that = (ConcreteMixer) obj;
            return that.getRequirements().equals(this.getRequirements());
        }
        return false;
    }
}
