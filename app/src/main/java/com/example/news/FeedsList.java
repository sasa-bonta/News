package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.news.RSS.RSSFeedActivity;

public class FeedsList extends AppCompatActivity {
    private static final String TAG = "TEST getLink";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d(TAG, "url = " + url);

    }
}
