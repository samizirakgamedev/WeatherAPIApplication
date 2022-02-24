package com.steelswans;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class ConnectionManager {
    private static ConnectionManager instance;
    public String baseUrl;
    public String city;
    public String apiKey;
    public String constructedUrl;
    public HttpClient httpClient;

    private ConnectionManager(String url, String city, String apiKey) {
        this.baseUrl = url;
        this.city = city;
        this.apiKey = apiKey;
        this.constructedUrl = this.baseUrl + this.city + this.apiKey;
        this.httpClient = HttpClient.newHttpClient();
    }

    public static ConnectionManager getConnection(String url, String city, String apiKey) {
        if (instance == null)
            instance = new ConnectionManager(url, city, apiKey);

        return instance;
    }

    public HttpRequest makeHttpRequest() {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(this.baseUrl))
                .build();

        return request;
    }

    public HttpResponse<String> getHttpResponse(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    // To Add - String Builder for url;
    // or? String.format("api.openweathermap.org/data/2.5/weather?q={%d}&appid={%d}", city, apikey)
    // FileReader class.
}
