package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Playlist {
    private List<Song> songs;
    private List<Ad> ads;

    public void addAd(Ad a) {
        Random x = new Random();
        if (!ads.isEmpty()) {
            int ad = (x.nextInt() % ads.size() + ads.size()) % ads.size();
            ads.add(0, ads.get(ad));
        } else ads.add(a);
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }

    public List<Ad> getAds() {
        return ads;
    }

    public double cost() {
        double cost = 0.0;
        for (int i = 0; i < ads.size(); i++)
            cost += ads.get(i).getCost();
        return cost;
    }

    public Playlist(AlbumCatalog a, AdCatalog b) {
        ArrayList<Album> albums = (ArrayList<Album>) a.getAlbums();
        ArrayList<Ad> addAds = (ArrayList<Ad>) b.getAds();
        ArrayList<Song> songs = new ArrayList<>();
        ArrayList<Ad> ads = new ArrayList<>();
        for (int i = 0; i < albums.size(); i++) {
            ArrayList<Song> addSongs = (ArrayList<Song>) albums.get(i).getSongs();
            for (int j = 0; j < addSongs.size()&&j<10; j++)
                songs.add(addSongs.get(j));
        }
        for (int i = 0; i < addAds.size(); i++) {
            ads.add(addAds.get(i));
        }
        Collections.shuffle(songs);
        Collections.shuffle(ads);
        while(songs.size()>9)
            songs.remove(songs.size()-1);
        while(ads.size()>9)
            ads.remove(ads.size()-1);
        this.songs = songs;
        this.ads = ads;
    }

    public void play() {
        String res = "";
        int i = 0;
        while (i < 10 && ads.size() > i && songs.size() > i) {
            res += "Track: " + songs.get(i).toString() + "\n";
            res += "AD: " + ads.get(i).toString() + "\n";
            i++;
        }
        System.out.println(res);
    }

    public void shuffle(int seed) {
        Collections.shuffle(songs, new Random(seed));
        Collections.shuffle(ads, new Random(seed));
    }

    public Playlist() {
        this.songs = new ArrayList<>();
        this.ads = new ArrayList<>();
    }

    public Playlist(List<Song> songs, List<Ad> ads) {
        this.songs = songs;
        this.ads = ads;
    }

    public void adFirst(Song x) {
        songs.add(0, x);
    }

    public void adSong(Song x) {
        songs.add(x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlist playlist = (Playlist) o;

        if (songs != null ? !songs.equals(playlist.songs) : playlist.songs != null) return false;
        return ads != null ? ads.equals(playlist.ads) : playlist.ads == null;
    }
}
