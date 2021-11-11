package com.company;

import java.util.Scanner;

public class Ad {
    private String name;
    private Time time;
    private double cost;

    public Time getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public Ad(String name, Time time, double cost) {
        this.name = name;
        this.cost = cost;
        this.time = time;
    }

    public static Ad read(String line) {
        Scanner parse = new Scanner(line).useDelimiter("\\s");
        String s = parse.next();
        parse.useDelimiter("; ");
        String name = parse.next();
        name = name.substring(1);
        Time time = Time.read(parse.next());
        String x = parse.next();
        parse = new Scanner(x);
        double cost = parse.nextDouble();
        return new Ad(name, time, cost);
    }

    public String toString() {
        return this.name + " (" + this.time.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (Double.compare(ad.cost, cost) != 0) return false;
        if (name != null ? !name.equals(ad.name) : ad.name != null) return false;
        return time != null ? time.equals(ad.time) : ad.time == null;
    }

}
