package com.steelswans;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Iterator;
import java.util.Objects;

public class WeatherAPIMain {
    private static JSONObject jsonObject;
    private static FileWriter file;

    public static void main(String[] args) {
        ConnectionManager cm = ConnectionManager.getConnection("https://api.openweathermap.org/data/2.5/weather?q=",
                "London", APIKeyFileReader.readAPIKeyFile("apikey.txt"));
        System.out.println(cm.constructedUrl);
        Injector injector = new Injector();
        jsonObject = injector.getJSONResponse(Objects.requireNonNull(cm.getHttpResponse(cm.makeHttpRequest())));
        Clouds clouds = new Clouds();
        Coord coord = new Coord();
        Main main = new Main();
        Sys sys = new Sys();
        Weather weather = new Weather();
        Wind wind = new Wind();
        Snow snow = new Snow();
        Rain rain = new Rain();
        injector.injectIntoDTO(jsonObject, clouds, coord, main, sys, weather, wind, snow, rain);

        System.out.println(weather);

//        try {
//            file = new FileWriter("testJSONObject.json");
//            file.write(jsonObject.toJSONString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                file.flush();
//                file.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        JSONParser parser = new JSONParser();
//        try {
//            Object obj = parser.parse(new FileReader("testJSONObject.json"));
//
//            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
//            JSONObject jsonObject = (JSONObject) obj;
//
//            // A JSON array. JSONObject supports java.util.List interface.
//
//            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
//            // Iterators differ from enumerations in two ways:
//            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
//            // 2. Method names have been improved.
//            System.out.println(jsonObject);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
