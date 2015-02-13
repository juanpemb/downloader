package org.jp.downloader.core;

import org.jp.downloader.infra.jsoup.DriverDealExtreme;
import org.jp.downloader.port.secondary.DriverPort;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DriveDealExtremeTest {

    @Test
    public void obtainSunGlass() {
        String path = "http://www.dx.com/es/s/gafas%2bde%2bsol?category=1244&PageIndex=1#sortBar";
        DriverPort driverDealExtreme = new DriverDealExtreme();

        List<SunGlass> result = driverDealExtreme.obtainSunGlass(path);

        assertTrue("Should be more than 1", result.size() > 0);

    }
}
