package com.example.kimschuiten.eventslister;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * MainActivity in which the user can choose the location and receive the weather information for
 * this location, to decide whether to stay in bed or not.
 */

public class MainActivity extends AppCompatActivity {

    ListView showEvents;
    EditText askLocation;
    Button findEvents;
    String chosenloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize
        showEvents = (ListView) findViewById(R.id.weatherListView);
        askLocation = (EditText) findViewById(R.id.locationEdtext);
        findEvents = (Button) findViewById(R.id.findAdviceBtn);
        chosenloc = askLocation.getText().toString();

        // Construct the data source
        ArrayList<WeatherData> arrayOfWeather = new ArrayList<WeatherData>();
        // Create the adapter to convert the array to views
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, arrayOfWeather);
        // Attach the adapter to a Listview
        ListView listView = (ListView) findViewById(R.id.weatherListView);
        listView.setAdapter(adapter);
    }

    public void getDataBtn(View view) {
        ClassAsyncTask task = new ClassAsyncTask(this);
        task.execute(chosenloc);
        }

    public void getDataBtn(ArrayList<WeatherData> weatherdata) {
        ClassAsyncTask task = new ClassAsyncTask(this);
        task.execute(chosenloc);
    }
}

