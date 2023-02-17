package com.example.coen390_ta1.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.example.coen390_ta1.R;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        //creation of a toolbar
        Toolbar actionbar = findViewById(R.id.action_bar);
        setSupportActionBar(actionbar);
        getSupportActionBar().setTitle("Data Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = findViewById(R.id.listview);
    }

    //Adding actions to the actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.datamenu,menu);
        return true;
    }
}