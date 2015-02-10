package org.jp.downloader.core;

import org.jp.downloader.port.secondary.DriverDealExtreme;

import java.util.ArrayList;
import java.util.List;

public class FinderSunGlass {

    public static String PATH = "http://www.dx.com/es/s/gafas%2bde%2bsol?category=1244&PageIndex=1#sortBar";

    private List<SunGlass> sunGlasses = new ArrayList<SunGlass>();


    public SunGlassCatalog retrieveSunGlass(String path) {

        DriverDealExtreme driver = new DriverDealExtreme(path);
        List<SunGlass> catalogFromDriver = driver.obtainSunGlass();

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
                    sunGlass.getPrice());

            catalog.add(sunGlass);
        }

        return catalog;
    }
}
