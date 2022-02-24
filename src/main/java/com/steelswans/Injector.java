package com.steelswans;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Injector {
    private static JSONParser jsonParser;
    private static JSONObject jsonObject;

    public static JSONObject getJSONResponse(HttpResponse<String> response) {
        try{
            String responseBody = response.body();
            jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void injectIntoDTO(JSONObject response){
        Clouds clouds = new Clouds();
        Coord coord = new Coord();
        Main main = new Main();
        Sys sys = new Sys();
        Weather weather = new Weather();
        Wind wind = new Wind();

        // clouds
        JSONObject jsonClouds = (JSONObject) response.get("clouds");
        clouds.setAll(Integer.parseInt(String.valueOf(jsonClouds.get("all"))));
        // coord
        JSONObject jsonCoord = (JSONObject) response.get("coord");
        coord.setLat(Double.parseDouble(String.valueOf(jsonCoord.get("lat"))));
        coord.setLon(Double.parseDouble(String.valueOf(jsonCoord.get("lon"))));
        // main
        JSONObject jsonMain = (JSONObject) response.get("main");
        main.setFeelsLike(Double.parseDouble(String.valueOf(jsonMain.get("feels_like"))));
        main.setHumidity(Integer.parseInt(String.valueOf(jsonMain.get("humidity"))));
        main.setPressure(Integer.parseInt(String.valueOf(jsonMain.get("pressure"))));
        main.setTemp(Double.parseDouble(String.valueOf(jsonMain.get("temp"))));
        main.setTempMax(Double.parseDouble(String.valueOf(jsonMain.get("temp_max"))));
        main.setTempMin(Double.parseDouble(String.valueOf(jsonMain.get("temp_min"))));
        // sys
        JSONObject jsonSys = (JSONObject) response.get("sys");
        sys.setCountry(String.valueOf(jsonSys.get("country")));
        sys.setId(Integer.parseInt(String.valueOf(jsonSys.get("id"))));
        sys.setSunrise(Integer.parseInt(String.valueOf(jsonSys.get("sunrise"))));
        sys.setSunset(Integer.parseInt(String.valueOf(jsonSys.get("sunset"))));
        sys.setType(Integer.parseInt(String.valueOf(jsonSys.get("type"))));

        // wind
        JSONObject jsonWind = (JSONObject) response.get("wind");
        wind.setDeg(Integer.parseInt(String.valueOf(jsonWind.get("deg"))));
        wind.setSpeed(Double.parseDouble(String.valueOf(jsonWind.get("speed"))));
//        wind.setGust(Double.parseDouble(String.valueOf(jsonWind.get("gust"))));
        // weather
        weather.setCoord(coord);
        weather.setClouds(clouds);
        weather.setMain(main);
        weather.setSys(sys);
        weather.setWind(wind);
        weather.setBase(String.valueOf(response.get("base")));
        weather.setCod(Integer.parseInt(String.valueOf(response.get("cod"))));
        weather.setDt(Integer.parseInt(String.valueOf(response.get("dt"))));
        weather.setVisibility(Integer.parseInt(String.valueOf(response.get("visibility"))));
        weather.setTimezone(Integer.parseInt(String.valueOf(response.get("timezone"))));
        weather.setId(Integer.parseInt(String.valueOf(response.get("id"))));
        weather.setName(String.valueOf(response.get("name")));

        // weatherItem
        JSONArray jsonWeatherItems = (JSONArray) response.get("weather");
        List<WeatherItem> weatherItems = new ArrayList<>();
        for (int i = 0; i < jsonWeatherItems.size(); i++){
            JSONObject jsonObject = (JSONObject) jsonWeatherItems.get(i);
            WeatherItem item = new WeatherItem();
            item.setId(Integer.parseInt(String.valueOf(jsonObject.get("id"))));
            item.setDescription(String.valueOf(jsonObject.get("description")));
            item.setIcon(String.valueOf(jsonObject.get("icon")));
            item.setMain(String.valueOf(jsonObject.get("main")));
            weatherItems.add(item);
        }
        weather.setWeather(weatherItems);
    }
}
