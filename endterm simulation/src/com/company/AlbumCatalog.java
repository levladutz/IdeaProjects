package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlbumCatalog {
    private List<Album> albums;

    public List<Album> getAlbums() {
        return albums;
    }

    public boolean contains(String title) {
        boolean ok = false;
        for (int i = 0; i < albums.size(); i++)
            if (albums.get(i).contains(title))
                ok = true;
        return ok;
    }

    /**
     *
     * @param title
     * @return
     */
    public Song getSong(String title) {
        for (int i = 0; i < albums.size(); i++)
            if (albums.get(i).contains(title))
                return albums.get(i).getSong(title);
        return null;
    }

    public static AlbumCatalog read(Scanner in) {
        ArrayList<Album> a = new ArrayList<>();
        in.nextLine();
        in.useDelimiter("ALBUM ");
        while (in.hasNext()) {
            String album = in.next();
            Scanner sep = new Scanner(album).useDelimiter("ADS");
            a.add(Album.read(sep.next()));
        }
        return new AlbumCatalog(a);
    }

    public AlbumCatalog(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumCatalog that = (AlbumCatalog) o;

        return albums != null ? albums.equals(that.albums) : that.albums == null;
    }

    @Override
    public String toString() {
        String res = "";

        for (int i = 0; i < albums.size(); i++)
            res += albums.get(i).toString();

        return res;
    }

}
