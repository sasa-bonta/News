package com.example.news.SQL;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * @author Bonta A
 * @version : 2.0
 */

/**
 * Functions of interaction with database.
 */
@Dao
public interface LinkDao {


    /**
     * Insert in DB
     */
    @Insert(onConflict = REPLACE)
    void insert(Link link);

    /**
     * Select all from DB
     */
    @Query("SELECT * FROM newsLinks")
    List<Link> getAll();

    /**
     * Delete from DB*
     */
    @Delete
    void delete(Link link);
}
