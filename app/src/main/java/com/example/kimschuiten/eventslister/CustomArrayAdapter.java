package com.example.kimschuiten.eventslister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Array adapter with two textviews, for the date and the weather information.
 */

public class CustomArrayAdapter extends ArrayAdapter<WeatherData> {
    public CustomArrayAdapter(Context context, ArrayList<WeatherData> weatherdata){
        super(context, 0, weatherdata);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Get the data item for this position
        WeatherData weather = getItem(position);
        // Check if an exising view is being reused, otherwise inflate the view
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_array_layout, parent, false);
        }
        // Lookup view for data population
        TextView dateTV = (TextView) convertView.findViewById(R.id.date);
        TextView weatherTV = (TextView) convertView.findViewById(R.id.weather);

        // Populate the data into the template view using the data object
        dateTV.setText(weather.date);
        weatherTV.setText(weather.weather);

        // Return the completed view to render on screen
        return convertView;
    }
}

