package com.steelswans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow {
    @JsonProperty("1h")
    private double snow1h;

    @JsonProperty("3h")
    private double snow3h;

    public double getSnow1h() {
        return snow1h;
    }

    public void setSnow1h(double snow1h) {
        this.snow1h = snow1h;
    }

    public double getSnow3h() {
        return snow3h;
    }

    public void setSnow3h(double snow3h) {
        this.snow3h = snow3h;
    }

    @Override
    public String toString() {
        return "Snow{" +
                "snow1h=" + snow1h +
                ", snow3h=" + snow3h +
                '}';
    }
}
