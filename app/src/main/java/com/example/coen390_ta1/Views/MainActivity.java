package com.example.coen390_ta1.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.coen390_ta1.R;

public class MainActivity extends AppCompatActivity {

    TextView TotalCountValue;
    Button AddButtonA;
    int ButtonA_count;
    Button AddButtonB;
    int ButtonB_count;
    Button AddButtonC;
    int ButtonC_count;
    Button SettingsButton;
    Button ShowMyCounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // adds all event to the Total Count
        //create a method and then sum all the events
            TotalCountValue = (TextView) findViewById(R.id.TotalCount);
            AddButtonA = (Button) findViewById(R.id.eventA);
            AddButtonB = (Button) findViewById(R.id.eventB);
            AddButtonC = (Button) findViewById(R.id.eventC);
            SettingsButton = (Button) findViewById(R.id.settings);
            ShowMyCounts = (Button) findViewById(R.id.ShowMyCounts);


        AddButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonA_count +=1;
                int sum = ButtonA_count + ButtonB_count + ButtonC_count;
                TotalCountValue.setText("Total Count:" + sum );
            }
        });

        AddButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonB_count +=1;
                int sum = ButtonA_count + ButtonB_count + ButtonC_count;
                TotalCountValue.setText("Total Count:" + sum );
            }
        });

        AddButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonC_count +=1;
                int sum = ButtonA_count + ButtonB_count + ButtonC_count;
                TotalCountValue.setText("Total Count:" + sum );
            }
        });


        //goes to settings activity after clicking the button settings
        SettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);

            }
        });

        //goes to data activity after clicking the button showmycounts
        ShowMyCounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,DataActivity.class);
                startActivity(intent);

            }
        });

        //create sharedpreferences
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("shared_pref", MODE_PRIVATE);
        String counter1name = sharedPreferences.getString("counter1name","");
        String counter2name = sharedPreferences.getString("counter2name","");
        String counter3name = sharedPreferences.getString("counter3name","");
        String max_count_value= sharedPreferences.getString("max_value_count","");

        AddButtonA.setText(counter1name);
        AddButtonB.setText(counter2name);
        AddButtonC.setText(counter3name);

        }



}