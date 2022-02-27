package com.steelswans.framework;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    public String baseUrl;
    public String city;
    public String apiKey;
    public String constructedUrl;
    public HttpClient httpClient;
    // Constructor for the ConnectionManager class.
    public ConnectionManager(String url, String city, String apiKey) {
        this.baseUrl = url;
        this.city = city;
        this.apiKey = apiKey;
        this.constructedUrl = this.baseUrl + this.city + "&appid=" + this.apiKey;
        this.httpClient = HttpClient.newHttpClient();
    }
    // Method for returning a HttpRequest using the URL.
    public HttpRequest returnHttpRequest() {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(this.constructedUrl))
                .build();
    }
    // Method for returning a HttpRequest as a String.
    public String returnStringHttpRequest() {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(this.constructedUrl))
                .build();
        return String.valueOf(request);
    }
    // Method for returning a HttpResponse using the HttpRequest.
    // Returned as a HttpResponse<String>.
    public HttpResponse<String> returnHttpResponse(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Method for returning a HttpResponse using the HttpRequest.
    // Returned as a String.
    public String returnStringHttpResponse(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
