package com.steelswans.framework;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ConnectionManager {
    public String baseUrl;
    public String city;
    public String apiKey;
    public String constructedUrl;
    public HttpClient httpClient;

    public ConnectionManager(String url, String city, String apiKey) {
        this.baseUrl = url;
        this.city = city;
        this.apiKey = apiKey;
        this.constructedUrl = this.baseUrl + this.city + "&appid=" + this.apiKey;
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpRequest returnHttpRequest() {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(this.constructedUrl))
                .build();
//        System.out.println("Request: " + request);

        return request;
    }

    public String returnStringHttpRequest() {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(this.constructedUrl))
                .build();

//        System.out.println("String Request: " + request);

        return String.valueOf(request);
    }

    public HttpResponse<String> returnHttpResponse(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println("Response: " + request);
            return response;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String returnStringHttpResponse(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println("Response: " + request);
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    // To Discuss with Mihai.
    public HttpResponse<String> getConnectionResponse() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = returnHttpRequest();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public Map<String, List<String>> getHeaders() {
        HttpHeaders headers = getConnectionResponse().headers();
        return headers.map();
    }

    // To Add - String Builder for url;
    // or? String.format("api.openweathermap.org/data/2.5/weather?q={%d}&appid={%d}", city, apikey)
}
