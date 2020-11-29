package com.example.news;

import android.content.Intent;
import android.os.Bundle;

import com.example.news.SQL.Link;
import com.example.news.SQL.LinksDatabase;
import com.example.news.SQL.MainAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bonta A
 * @version : 2.0
 */

/**
 * MainActivity is the activity user sees when turning on the application
 * It extends AppcompatActivity class
 * @see AppCompatActivity
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Link> linkList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    LinksDatabase database;
    MainAdapter adapter;

    /**
     * OnCreate method
     * Layout activity main
     * @param savedInstanceState represent reference to Bundle object that is passed into the OnCreate method of every Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Sends represent reference to Bundle object to supper class
         */
        super.onCreate(savedInstanceState);
        /**
         * Sets activity_main layout as UI of this class
         */
        setContentView(R.layout.activity_main);

        /**
         * Declaration of objects
         */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        database = LinksDatabase.getInstance(this);
        linkList = database.linkDao().getAll();
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(MainActivity.this, linkList);
        recyclerView.setAdapter(adapter);
        /**
         * declaration of addLink method
         */
        addLink();
    }

    /**
     * Inflate the menu; this adds items to the action bar if it is present.
     *      * Menu
     * @param menu is object from Menu.class interface
     * @return When you successfully handle a menu item return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * When the user selects an item from the options menu
     * @param item Interface for direct access to a previously created menu item
     * @return true if an item was selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         *  Handle action bar item clicks here
         *  The action bar will automatically handle clicks on the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
         */
        int id = item.getItemId();

        /**
         * action_setting is not used in this application
         */
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Function to add new links to database
     */
    public void addLink () {
        FloatingActionButton fab = findViewById(R.id.fab);
        /**
         * Handler of FloatingActionButton
         * @see fab
         */
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Intent to AddLink.class
                 * @see AddLink
                 */
                Intent intent = new Intent(MainActivity.this, AddLink.class);
                startActivity(intent);
            }
        });
    }
}