package org.jp.downloader.core;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FinderSunGlassTest {

    @Test
    public void obtainSunForUrl()
    {
        FinderSunGlass finder = new FinderSunGlass();

        SunGlassCatalog catalog = finder.retrieveSunGlass();

        assertTrue("catalog should not be empty", catalog.size() > 0);
    }
}

