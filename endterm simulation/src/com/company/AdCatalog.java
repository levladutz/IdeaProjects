package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdCatalog {
    private List<Ad> ads;

    public AdCatalog(List<Ad> ads) {
        this.ads = ads;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public static AdCatalog read(Scanner in) {
        ArrayList<Ad> a = new ArrayList<>();
        in.useDelimiter("ADS");
        in.next();
        String ads = in.next();
        in = new Scanner(ads);
        in.nextLine();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            a.add(Ad.read(line));
        }
        return new AdCatalog(a);
    }

    public void addAd(Ad a) {
        ads.add(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdCatalog adCatalog = (AdCatalog) o;

        return ads != null ? ads.equals(adCatalog.ads) : adCatalog.ads == null;
    }

}
