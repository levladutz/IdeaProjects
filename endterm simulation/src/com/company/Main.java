package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please specify a file:");
        String file = input.nextLine();
        Scanner fileRead = new Scanner(new File("resources/deezer.txt"));
        //resources/deezer.txt
        AlbumCatalog catalog = AlbumCatalog.read(fileRead);
        fileRead = new Scanner(new File("resources/deezer.txt"));
        AdCatalog ads = AdCatalog.read(fileRead);
        Playlist playlist = new Playlist();

        String menu = "1 - Print all the albums & songs\n" +
                "2 - Add a new advertisement\n" +
                "3 - Enable shuffling of songs\n" +
                "4 - Add song to the front of playlist\n" +
                "5 - Write to file\n" +
                "6 - Calculate commercial value\n" +
                "7 - Stop the program";

        while (true) {
            System.out.println(menu);
            int option = input.nextInt();
            if (option == 1)
                System.out.println(catalog.toString());
            else if (option == 2)
                option2(ads);
            else if (option == 3) {
                playlist = new Playlist(catalog, ads);
                option3(catalog, ads, playlist);
            }
            else if (option == 4)
                option4(catalog, ads, playlist);
            else if (option == 5)
                option5(catalog, ads, file);
            else if (option == 6)
                option6(playlist);
            else if (option == 7)
                System.exit(0);
        }
    }

    private static void option6(Playlist playlist) {

        System.out.println("The price of the current playlist is:");
        if (playlist.isEmpty()) {
            System.out.println("0.00 euros");
            return;
        }
        double totalCost = playlist.getAds().stream()
                .map(ad -> ad.getCost())
                .mapToDouble(ad -> ad)
                .sum();
        System.out.println(totalCost + " euros");
    }

    public static void option5(AlbumCatalog catalog, AdCatalog ads, String file) throws IOException {
        String res = "";
        res+="\n";
        FileWriter writer = new FileWriter(file);
        res += "ALBUMS\n";
        res += "ALBUM ";
        ArrayList<Album> albums = (ArrayList<Album>) catalog.getAlbums();
        for (int i = 0; i < albums.size(); i++) {
            Album x = albums.get(i);
            res += "ALBUM " + x.getArtist() + "; " + x.getName() + "; " + x.getYear() + "\n";

            ArrayList<String> artists = (ArrayList<String>) x.getArtists();
            res += "ARTISTS ";
            for (int j = 0; j < artists.size(); j++) {
                res += artists.get(j);
                if (j != artists.size() - 1)
                    res += "; ";

            }
            res += '\n';
            ArrayList<Song> songs = (ArrayList<Song>) x.getSongs();
            for (int j = 0; j < songs.size(); j++) {
                Song current = songs.get(j);
                res += "TRACK " + (j + 1) + "; " + current.getName() + "; " + current.getTime().toString() + "\n";
            }
        }
        ArrayList<Ad> adList = (ArrayList<Ad>) ads.getAds();
        res += "ADS\n";
        for (int i = 0; i < adList.size(); i++) {
            Ad ad = adList.get(i);
            res += "AD " + ad.getName() + "; " + ad.getTime().toString() + "; " + ad.getCost() + " euros\n";
        }
        writer.write(res);
        writer.close();
    }

    public static void option4(AlbumCatalog catalog, AdCatalog ads, Playlist playlist) {
        System.out.println("Name of the song:");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        if (catalog.contains(title)) {
            playlist.adFirst(catalog.getSong(title));
            playlist.addAd(ads.getAds().get(0));
        } else
            System.out.print("There is no song with that title");
        playlist.play();
    }

    public static void option3(AlbumCatalog catalog, AdCatalog ads, Playlist playlist) {
        Random x = new Random();
        playlist.shuffle(x.nextInt());
        playlist.play();
    }

    public static void option2(AdCatalog ads) {
        Scanner in = new Scanner(System.in);
        System.out.println("Company name:\n");
        String name = in.next();
        System.out.println("Duration:\n");
        Time time = Time.read(in.next());
        System.out.println("Cost:\n");
        double cost = in.nextDouble();
        ads.addAd(new Ad(name, time, cost));
    }
}
