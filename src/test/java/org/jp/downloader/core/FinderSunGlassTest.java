package org.jp.downloader.core;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FinderSunGlassTest {

    private String path = "http://www.dx.com/es/s/gafas%2bde%2bsol?category=1244&PageIndex=1#sortBar";

    @Test
    public void obtainSunForUrl()
    {
        FinderSunGlass finder = new FinderSunGlass();

        SunGlassCatalog catalog = finder.retrieveSunGlass(path);

        assertTrue("catalog should not be empty", catalog.size() > 0);
    }
}

