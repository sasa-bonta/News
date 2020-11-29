package com.example.news.RSS;

/**
 * @author Bonta Alexandr
 * @version : 1.0
 */

/**
 * List of zmm tags displayed after pressing an RSS link item from the MainActivity
 * @see com.example.news.MainActivity
 */
public class RSSItem {

    public String title;
    public String link;
    public String description;
    public String pubdate;
    public String guid;

    /**
     * Constructor of RSSItem object
     * @param title title of article
     * @param link link to the article
     * @param description short description of the article
     * @param pubdate publication date of the article
     * @param guid unknown staff, but important, I guess. Used in RSSParser
     * @see RSSParser
     */
    public RSSItem(String title, String link, String description, String pubdate, String guid) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubdate = pubdate;
        this.guid = guid;
    }
}
