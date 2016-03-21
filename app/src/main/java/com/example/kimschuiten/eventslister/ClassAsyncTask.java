package com.example.kimschuiten.eventslister;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * AsyncTask that parses data from the httpRequestHelper and updates this to the MainActivity when
 * the user clicks the "Find Advice" button.
 */
public class ClassAsyncTask extends AsyncTask<String, Integer, String> {

    private Context context;
    private MainActivity activity;

    // Constructor
    public ClassAsyncTask(MainActivity activity){
        super();
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        // Show user you will fetch data
        Toast.makeText(context, "Getting data from server", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... params){
        // Get data from server
        return httpRequestHelper.downloadFromServer(params);
    }

    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
    }

    protected void onPostExecute(String result){
        super.onPostExecute(result);
 
        // Alert user if nothing was found
        if(result.length() == 0){
            Toast.makeText(context, "Nothing was found", Toast.LENGTH_SHORT).show();
        }
        else {
            // Parse JSON
            ArrayList<WeatherData> weatherdata = new ArrayList<>();
            try {
                JSONObject respObj = new JSONObject(result);
                JSONObject forecastObj = respObj.getJSONObject("forecast");
                JSONArray dates = forecastObj.getJSONArray("date");
                JSONArray weatherArray = forecastObj.getJSONArray("text");

                for (int i = 0; i<dates.length(); i++){
                    JSONObject date = dates.getJSONObject(i);
                    String weather = date.getString("text");
                    weatherdata.add(new WeatherData(date));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // Update MainActivity
            this.activity.getDataBtn(weatherdata);
        }
    }
}
