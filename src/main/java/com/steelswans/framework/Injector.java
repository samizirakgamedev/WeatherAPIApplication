package com.steelswans.framework;

import com.steelswans.dto.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Injector {
    private JSONParser jsonParser;
    private JSONObject jsonObject;

    public JSONObject getJSONResponse(HttpResponse<String> response) {
        try{
            String responseBody = response.body();
            jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public JSONObject getJSONResponseBody(String responseBody){
        try{
            jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void injectIntoDTO(JSONObject response, Clouds clouds, Coord coord, Main main, Sys sys, Weather weather,
                              Wind wind, Snow snow, Rain rain){

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
        sys.setMessage(String.valueOf(jsonSys.get("message")));
        // wind
        JSONObject jsonWind = (JSONObject) response.get("wind");
        wind.setDeg(Integer.parseInt(String.valueOf(jsonWind.get("deg"))));
        wind.setSpeed(Double.parseDouble(String.valueOf(jsonWind.get("speed"))));
        if (jsonWind.get("wind") != null) {
            wind.setGust(Double.parseDouble(String.valueOf(jsonWind.get("gust"))));
        }

        // rain
        if (response.get("rain") != null) {
            JSONObject jsonRain = (JSONObject) response.get("rain");
            if (jsonRain.get("1h") != null) {
                rain.setRain1h(Double.parseDouble(String.valueOf(jsonRain.get("1h"))));
            }
            if (jsonRain.get("3h") != null) {
                rain.setRain3h(Double.parseDouble(String.valueOf(jsonRain.get("3h"))));
            }
        }
        //snow
        if (response.get("snow") != null) {
            JSONObject jsonSnow = (JSONObject) response.get("snow");
            if (jsonSnow.get("1h") != null) {
                if (jsonSnow.get("3h") != null) {
                    snow.setSnow1h(Double.parseDouble(String.valueOf(jsonSnow.get("1h"))));
                }
            }
            snow.setSnow3h(Double.parseDouble(String.valueOf(jsonSnow.get("3h"))));
        }

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
        if (rain != null) {
            weather.setRain(rain);
        }
        if (snow != null) {
            weather.setSnow(snow);
        }

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
