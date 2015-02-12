package org.jp.downloader.core;

import org.jp.downloader.infra.jsoup.DriverDealExtreme;

import java.util.List;

public class FinderSunGlass {

    public static String PATH = "http://www.dx.com/es/s/gafas%2bde%2bsol?category=1244&PageIndex=1#sortBar";


    public SunGlassCatalog retrieveSunGlass(String path) {

        DriverDealExtreme driver = new DriverDealExtreme();
        List<SunGlass> catalogFromDriver = driver.obtainSunGlass(path);

        return adapt(catalogFromDriver);
    }

    private SunGlassCatalog adapt(List<SunGlass> catalogFromDriver) {

        SunGlassCatalog catalog = new SunGlassCatalog();

        for (SunGlass sunGlass : catalogFromDriver) {
            SunGlass copySunGlass = new SunGlass(sunGlass.getStarts(),
                    sunGlass.getTitle(),
                    sunGlass.getReviews(),
                    sunGlass.getDescriptions(),
                    sunGlass.getDetails(),
                    sunGlass.getPrice(),
                    sunGlass.getUrl());

            catalog.add(copySunGlass);
        }

        return catalog;
    }
}
