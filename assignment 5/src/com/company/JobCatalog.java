package com.company;

import java.util.*;

public class JobCatalog {
    private List<Job> jobs;

    public JobCatalog() {
        this.jobs = new ArrayList<Job>();
    }

    public void addJob(Job job)
    {
        this.jobs.add(job);
    }
    public String toString() {
        String res = "";
        res += "Jobs:\n";
        for (int i = 0; i < this.jobs.size(); i++)
            res += this.jobs.get(i).toString()+"\n";
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof JobCatalog) {
            JobCatalog that = (JobCatalog) o;
            if (this.jobs.equals(that.jobs))
                return true;
            return false;
        }
        return false;
    }
}
