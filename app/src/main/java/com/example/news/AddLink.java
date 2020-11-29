package com.example.news;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.news.SQL.Link;
import com.example.news.SQL.LinksDatabase;
import com.example.news.SQL.MainAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bonta A
 * @version : 2.0
 */

/**
 * AddLink class used for adding new RSS link to database
 * It extends AppcompatActivity class
 * @see AppCompatActivity
 */
public class AddLink extends AppCompatActivity {

    private static final String TAG = "Add link";

    /**
     * onCreate method is executed when Intent calls AddLink class
     * @param savedInstanceState represent reference to Bundle object that is passed into the OnCreate method of every Activity.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        /**
         * Sends represent reference to Bundle object to supper class
         */
        super.onCreate(savedInstanceState);
        /**
         * Sets add_link as UI of this class
         */
        setContentView(R.layout.add_link);
        /**
         * declaration of addLink method
         */
        addLink();
    }

    /**
     * Takes link from EditText with id: edit_text
     *  Functions while pressing addBtn
     */
    public void addLink() {

        /**
         * Declaration of buttons for adding and editing an element of database
         */
        final EditText editText = findViewById(R.id.edit_text);
        final Button button = findViewById(R.id.addBtn);

        /**
         * Handler of button used for adding new RSS link to database
         * @see button
         */
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * Handler of button used for adding new RSS link
             * @param view  is the basic building block of UI
             */
            @Override
            public void onClick(View view) {
                /**
                 * sLink is variable that contains text introduced in editText
                 * @see editText
                 */
                String sLink = editText.getText().toString().trim();

                /**
                 * linkList is a list that contains all RSS links from database
                 * database is object of database class
                 * adapter is object of aMainAdapter class
                 */
                List<Link> linkList = new ArrayList<>();
                LinksDatabase database;
                MainAdapter adapter;

                /**
                 * string contained in sLink is being added to database
                 * @see database
                 * @see adapter
                 * @see linkList
                 */
                database = LinksDatabase.getInstance(AddLink.this);
                linkList = database.linkDao().getAll();

                /**
                 * Logging of sLink
                 * @see TAG
                 */
                Log.d(TAG, "link : " + sLink);

                /**
                 * Checking if sLink isn't empty
                 * If the link is not null it is added to database
                 * @see sLink
                 */
                if (!sLink.equals("")) {

                    Link link = new Link();
                    link.setLink(sLink);

                    /**
                     * Inserting link into database
                     */
                    database.linkDao().insert(link);

                    /**
                     * Setting text from editText to empty
                     * @see editText
                     */
                    editText.setText("");

                    /**
                     * New intent to MainActivity
                     * @see MainActivity
                     */
                    Intent intent = new Intent(AddLink.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}
