package com.company;

import java.util.*;

public class Time {
    private int mm;
    private int hh;

    public Time(int hh, int mm)
    {
        this.hh=hh;
        this.mm=mm;
    }

    public static Time read(String in) {
        Scanner parse = new Scanner(in).useDelimiter(":");
        int hh = parse.nextInt();
        int mm = parse.nextInt();
        return new Time(hh,mm);
    }

    @Override
    public String toString() {
        return hh+":"+mm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Time)) return false;

        Time time = (Time) o;

        if (mm != time.mm) return false;
        return hh == time.hh;
    }
}
