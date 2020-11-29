package com.example.news.SQL;

import java.io.Serializable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Bonta A
 * @version : 2.0
 */

/**
 * Entity of database
 * Implements Serializable
 * @see Serializable
 */
@Entity(tableName = "newsLinks")
public class Link implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "link")
    private String link;

    /**
     * get id
     * @return id of link from database
     */
    public int getId() {
        return id;
    }

    /**
     * sets id
     * is never used
     * @param id id of link from database
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets link
     * @return  RSS link fron database
     */
    public String getLink() {
        return link;
    }

    /**
     * sets link
     * @param link String with RSS link from database
     */
    public void setLink(String link) {
        this.link = link;
    }
}
