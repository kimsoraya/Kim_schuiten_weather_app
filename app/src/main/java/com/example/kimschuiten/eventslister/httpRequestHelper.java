package com.example.kimschuiten.eventslister;

import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * httpRequestHelper that uses yahoo api to look up weather data
 */
public class httpRequestHelper {

    protected static synchronized String downloadFromServer(String... params){

        String url1 = "query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22";
        String url2 = "%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

        // Return String
        String returnValue = " ";

        // Get user location from AsyncTask
        String chosenloc = params[0];

        // Get complete url from string
        String completeurl = url1 + chosenloc + url2;
        URL url = null;
        try {
            url = new URL(completeurl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Make connection
        HttpURLConnection connection;
        if (url != null){
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // Read the response
                int response = connection.getResponseCode();

                if (200 <= response && response <= 299){
                    // Read in data
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = br.readLine()) != null){
                        returnValue = returnValue + line;
                    }
                }
                else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Return read data
        return returnValue;
    }
}