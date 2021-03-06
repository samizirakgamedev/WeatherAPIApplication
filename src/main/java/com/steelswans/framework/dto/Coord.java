package com.steelswans.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// A DTO class to store coordinates data
public class Coord{

	@JsonProperty("lon")
	private double lon;

	@JsonProperty("lat")
	private double lat;

	public double getLon(){
		return lon;
	}

	public double getLat(){
		return lat;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Coord{" +
				"lon=" + lon +
				", lat=" + lat +
				'}';
	}
}