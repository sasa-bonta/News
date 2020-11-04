package com.example.news.SQL;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface LinkDao {

    @Insert(onConflict = REPLACE)
    void insert(Link link);

    @Query("SELECT * FROM newsLinks")
    List<Link> getAll();

    @Delete
    void delete(Link link);
}
