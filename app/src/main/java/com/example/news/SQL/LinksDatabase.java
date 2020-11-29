package com.example.news.SQL;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**@author Bonta A
 @version : 2.0**/

/**Declaring the DB**/
@Database(entities = {Link.class}, version = 1, exportSchema = false)
public abstract class LinksDatabase extends RoomDatabase {



    private static LinksDatabase database;
    private static String DATABASE_NAME = "database";

    public synchronized static LinksDatabase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    LinksDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return database;

    }

    public abstract LinkDao linkDao();

}