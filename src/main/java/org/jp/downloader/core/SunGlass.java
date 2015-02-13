package org.jp.downloader.core;

import static junit.framework.Assert.assertNotNull;

public class SunGlass {

    private final String url;
    private String starts;
    private String title;
    private String reviews;
    private String descriptions;
    private String details;
    private String price;


    public SunGlass(String starts, String title, String reviews, String descriptions, String details, String price, String url) {

        assertNotNull("title should not null", title);
        assertNotNull("descriptions should not null", descriptions);
        assertNotNull("details should not null", details);
        assertNotNull("price should not null", price);
        assertNotNull("url should not null", url);


        this.starts = starts;
        this.title = title;
        this.reviews = reviews;
        this.descriptions = descriptions;
        this.details = details;
        this.price = price;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getStarts() {
        return starts;
    }

    public String getReviews() {
        return reviews;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getDetails() {
        return details;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }
}
