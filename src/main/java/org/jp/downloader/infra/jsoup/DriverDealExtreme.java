package org.jp.downloader.infra.jsoup;

import org.jp.downloader.core.SunGlass;
import org.jp.downloader.port.secondary.DriverPort;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DriverDealExtreme implements DriverPort {


    public List<SunGlass> obtainSunGlass(String path) {

        List<SunGlass> result = new ArrayList<SunGlass>();
        Document doc = null;
        Elements photosElement = null;

        doc = getDocument(path);

        Element productList = doc.getElementById("s_product_list");
        photosElement = productList.getElementsByClass("pt");
        Elements productsElement = productList.getElementsByClass("pi");


        Iterator photosIterator = photosElement.iterator();
        Iterator productsIterator = productsElement.iterator();
        while (photosIterator.hasNext() && productsIterator.hasNext()) {
            Element photoElement = (Element) photosIterator.next();
            String url = photoElement.getElementsByTag("a").attr("href");
            String title = photoElement.getElementsByTag("img").attr("alt");
            Element productElement = (Element) productsIterator.next();
            String details = productElement.getElementsByClass("detail").get(0).text();
            String starts = productElement.getElementsByClass("review").get(0).getElementsByClass("starts").get(0).getElementsByTag("span").attr("class");
            String price = productElement.getElementsByClass("price").text();
            //FIXME add description
            String description = "";


            SunGlass sunGlass = new SunGlass(starts,
                    title,
                    null,
                    description,
                    details,
                    price,
                    url);


            result.add(sunGlass);
        }

        return result;
    }

    private Document getDocument(String path) {

        Document doc = null;
        try {
            doc = Jsoup.connect(path).
                    userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.76.4  (KHTML, like Gecko) Version/7.0.4 Safari/537.76.4").
                    timeout(10 * 1000).
                    ignoreContentType(true).
                    ignoreHttpErrors(true).
                    followRedirects(true).
                    get();
        } catch (Exception e) {
            throw new RuntimeException("Error reading doc");
        }


        return doc;
    }
}
