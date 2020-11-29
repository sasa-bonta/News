package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Bonta A
 * @version : 2.0
 */

/**
 * Class FeedList for news_view layout
 *  The layout is for displaying news feeds
 *  It extends AppcompatActivity class
 * @see AppCompatActivity
 */
public class FeedsList extends AppCompatActivity {

    private static final String TAG = "TEST getLink";

    /**
     * onCreate class is executed when Intent calls FeedList.class
     * @param savedInstanceState represent reference to Bundle object that is passed into the OnCreate method of every Activity
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        /**
         * Sends represent reference to Bundle object to supper class
         */
        super.onCreate(savedInstanceState);
        /**
         * Sets news_layout as UI of this class
         */
        setContentView(R.layout.news_view);

        /**
         * Gets additional sent parameter
         * TAG is uses for logging
         * @see TAG
         */
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d(TAG, "url = " + url);

    }
}
