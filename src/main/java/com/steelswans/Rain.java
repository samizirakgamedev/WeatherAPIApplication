package com.steelswans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    @JsonProperty("1h")
    private double rain1h;

    @JsonProperty("3h")
    private double rain3h;

    public double getRain1h() {
        return rain1h;
    }

    public void setRain1h(double rain1h) {
        this.rain1h = rain1h;
    }

    public double getRain3h() {
        return rain3h;
    }

    public void setRain3h(double rain3h) {
        this.rain3h = rain3h;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "rain1h=" + rain1h +
                ", rain3h=" + rain3h +
                '}';
    }
}
