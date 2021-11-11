package com.company;

import java.util.*;

public class Album {
    private String name;
    private String artist;
    private int year;
    private List<String> artists;
    private List<Song> songs;

    public List<String> getArtists() {
        return artists;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public boolean contains(String title) {
        boolean ok = false;
        for (int i = 0; i < songs.size(); i++)
            if (songs.get(i).contains(title))
                ok = true;
        return ok;
    }


    public Song getSong(String title) {
        for (int i = 0; i < songs.size(); i++)
            if (songs.get(i).contains(title))
                return songs.get(i);
        return null;
    }

    public static Album read(String album) {
        Scanner in = new Scanner(album);

        String title = in.nextLine();
        Scanner parse = new Scanner(title).useDelimiter("; ");
        String artist = parse.next();
        String name = parse.next();
        int year = parse.nextInt();

        ArrayList<String> artists = new ArrayList<>();
        String line = in.nextLine();
        parse = new Scanner(line);
        parse.next();
        parse.useDelimiter("; ");
        while (parse.hasNext())
            artists.add(parse.next());

        ArrayList<Song> songs = new ArrayList<>();
        while (in.hasNextLine()) {
            songs.add(Song.read(in.nextLine()));
        }
        return new Album(artist, name, year, artists, songs);
    }

    public Album(String artist, String name, int year, List<String> artists, List<Song> songs) {
        this.name = name;
        this.artist = artist;
        this.artists = artists;
        this.songs = songs;
        this.year = year;
    }

    @Override
    public String toString() {
        String res = "";
        String space = "    ";
        res += "Album: " + this.name + " " + this.year + "\n";

        res += "Artists: ";
        for (int i = 0; i < artists.size(); i++) {
            res += artists.get(i);
            if (i != artists.size() - 1)
                res += ", ";
        }
        res += "\n";

        for (int i = 0; i < songs.size(); i++)
            res += space + "Track: " + songs.get(i).toString() + "\n";
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (year != album.year) return false;
        if (name != null ? !name.equals(album.name) : album.name != null) return false;
        if (artist != null ? !artist.equals(album.artist) : album.artist != null) return false;
        if (artists != null ? !artists.equals(album.artists) : album.artists != null) return false;
        return songs != null ? songs.equals(album.songs) : album.songs == null;
    }

}
