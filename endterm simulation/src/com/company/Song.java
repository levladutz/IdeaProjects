package com.company;

import java.util.Scanner;

public class Song {
    private String name;
    private Time time;

    public String getName() {
        return name;
    }

    public Time getTime() {
        return time;
    }

    public Song(String name, Time time) {
        this.name = name;
        this.time = time;
    }

    public static Song read(String line) {
        Scanner parse = new Scanner(line).useDelimiter("; ");
        parse.next();
        String name = parse.next();
        Time time = Time.read(parse.next());
        return new Song(name, time);
    }

    public boolean contains(String title) {
        return title.equals(name);
    }

    @Override
    public String toString() {
        return this.name + " (" + this.time.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Song)) return false;

        Song song = (Song) o;

        if (name != null ? !name.equals(song.name) : song.name != null) return false;
        return time != null ? time.equals(song.time) : song.time == null;
    }

}
