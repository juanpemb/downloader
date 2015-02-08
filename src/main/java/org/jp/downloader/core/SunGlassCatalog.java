package org.jp.downloader.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SunGlassCatalog implements Iterable<SunGlass> {

    private List<SunGlass> catalog = new ArrayList<SunGlass>();

    public long size() {
        return catalog.size();
    }

    public void add(SunGlass sunGlass) {
        catalog.add(sunGlass);
    }

    @Override
    public Iterator<SunGlass> iterator() {
        return catalog.iterator();
    }
}
