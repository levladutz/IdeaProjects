package com.company;
import java.util.*;
abstract class Equipment {
    private String requirements;
    public Equipment(String requirements)
    {
        this.requirements=requirements;
    }

    public String getRequirements() {
        return this.requirements;
    }
    public abstract String toString();
    public abstract boolean equals(Object obj);
}



