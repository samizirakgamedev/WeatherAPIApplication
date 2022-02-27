package com.steelswans.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// Method to store wind data
public class Wind{

	@JsonProperty("deg")
	private int deg;

	@JsonProperty("speed")
	private double speed;

	@JsonProperty("gust")
	private double gust;

	public int getDeg(){
		return deg;
	}

	public double getSpeed(){
		return speed;
	}

	public double getGust() {
		return gust;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setGust(double gust){
		this.gust = gust;
	}

	@Override
	public String toString() {
		return "Wind{" +
				"deg=" + deg +
				", speed=" + speed +
				", gust=" + gust +
				'}';
	}
}