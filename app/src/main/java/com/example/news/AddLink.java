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

public class AddLink extends AppCompatActivity {

    private static final String TAG = "Add link";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_link);

        addLink();
    }

    public void addLink() {

        final EditText editText = findViewById(R.id.edit_text);
        final Button button = findViewById(R.id.addBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sLink = editText.getText().toString().trim();

                List<Link> linkList = new ArrayList<>();
                LinksDatabase database;
                MainAdapter adapter;

                database = LinksDatabase.getInstance(AddLink.this);
                linkList = database.linkDao().getAll();

                Log.d(TAG, "link : " + sLink);

                if (!sLink.equals("")) {
                    Link link = new Link();
                    link.setLink(sLink);

                    database.linkDao().insert(link);

                    editText.setText("");

                    Intent intent = new Intent(AddLink.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}
