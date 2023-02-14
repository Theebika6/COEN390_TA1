package com.example.coen390_ta1.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coen390_ta1.R;

public class SettingsActivity extends AppCompatActivity {

    EditText Counter1NameText;
    EditText Counter2NameText;
    EditText Counter3NameText;
    Button Save;
    EditText MaxCounts;
    SharedPreferences shared_pref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //creation of a toolbar
        Toolbar actionbar = findViewById(R.id.action_bar);
        setSupportActionBar(actionbar);
        getSupportActionBar().setTitle("Settings Activity");

        Counter1NameText = (EditText)findViewById(R.id.Counter1NameText);
        Counter2NameText = (EditText)findViewById(R.id.Counter2NameText);
        Counter3NameText = (EditText)findViewById(R.id.Counter3NameText);
        Save = (Button) findViewById(R.id.save);
        MaxCounts = (EditText) findViewById(R.id.MaxCountGoesHere);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String max_count_value= MaxCounts.getText().toString();
                int NumOfTotalCounts=Integer.parseInt(max_count_value);

                // Set an if else statement

                if (Counter1NameText.getText().toString().isEmpty() || Counter2NameText.getText().toString().isEmpty() || Counter3NameText.getText().toString().isEmpty() || MaxCounts.getText().toString().isEmpty()) {
                    Toast.makeText(SettingsActivity.this, "Error, one or many fields are empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (NumOfTotalCounts < 5 || NumOfTotalCounts > 199){
                        Toast.makeText(SettingsActivity.this, "Error, max count is not between 5 and 200",Toast.LENGTH_SHORT).show();
                        return;
                    }

                String counter1name = Counter1NameText.getText().toString();
                String counter2name = Counter2NameText.getText().toString();
                String counter3name = Counter3NameText.getText().toString();
                shared_pref = getSharedPreferences("shared_pref", MODE_PRIVATE);

                SharedPreferences.Editor editor = shared_pref.edit();
                editor.putString("counter1name",counter1name);
                editor.putString("counter2name",counter2name);
                editor.putString("counter3name",counter3name);
                editor.putString("max_count_value",max_count_value);
                editor.commit();
                Toast.makeText(SettingsActivity.this, "The information is saved", Toast.LENGTH_LONG);

                    // After saving goes back to the main page
                    Intent intent = new Intent(SettingsActivity.this,MainActivity.class);
                    startActivity(intent);
            }
        });
    }

    //Adding actions to the actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settingsmenu,menu);
        return true;
    }
}