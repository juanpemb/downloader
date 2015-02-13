package org.jp.downloader.port.secondary;

import org.jp.downloader.core.SunGlass;

import java.util.List;

/**
 * Created by JuanPe on 13/02/2015.
 */
public interface DriverPort {
    public List<SunGlass> obtainSunGlass(String path);
}
