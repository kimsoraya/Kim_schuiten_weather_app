package com.example.kimschuiten.eventslister;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * WeatherData class that returns a weather ArrayList.
 */
public class WeatherData {
    // Fields
    public String date;
    public String weather;

    // Constructor
    public WeatherData(JSONObject object) {
        date = object.optString("date");
        weather = object.optString("weather");
/*            JSONArray dates = object.getJSONArray("date");
            JSONArray weather = object.getJSONArray("text");*/
    }

    // Method to convert an array of JSON objects into a list of objects
    public static ArrayList<WeatherData> fromJson(JSONArray jsonObjects){
        ArrayList<WeatherData> weather = new ArrayList<WeatherData>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                weather.add(new WeatherData(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return weather;
    }

}






   /* public WeatherData(JSONObject object){
        try{
            this.date = object.getString("date");
            this.weather = object.getString("text");
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    // Method to convert an array of JSON objects into a list of objects
    public static ArrayList<WeatherData> fromJson(JSONArray jsonObjects){
        ArrayList<WeatherData> weather = new ArrayList<WeatherData>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                weather.add(new WeatherData(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return weather;
    }
*/


/*
    public User(JSONObject object){
        try {
            this.name = object.getString("name");
            this.hometown = object.getString("hometown");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // Factory method to convert an array of JSON objects into a list of objects
    // User.fromJson(jsonArray);
    public static ArrayList<User> fromJson(JSONArray jsonObjects) {
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                users.add(new User(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return users;
    }*/


  /*  // Fields: properties of class object
    public JSONObject date;
    public String weather;

    // Constructor: defines how instance is created
    public WeatherData (JSONObject dateArg, String weatherArg){
        this.date = dateArg;
        this.weather = weatherArg;
    }

    // Methods
    public void setWeather(String weatherArg){
        weather = weatherArg;
    }

    public String getWeather(){
        return weather;
    }*/
