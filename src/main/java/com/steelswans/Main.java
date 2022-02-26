package com.steelswans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main{

	@JsonProperty("temp")
	private double temp;

	@JsonProperty("temp_min")
	private double tempMin;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("pressure")
	private int pressure;

	@JsonProperty("feels_like")
	private double feelsLike;

	@JsonProperty("temp_max")
	private double tempMax;

	@JsonProperty("sea_level")
	private int sea_level;

	@JsonProperty("grnd_level")
	private int grnd_level;

	public double getTemp(){
		return temp;
	}

	public double getTempMin(){
		return tempMin;
	}

	public int getHumidity(){
		return humidity;
	}

	public int getPressure(){
		return pressure;
	}

	public double getFeelsLike(){
		return feelsLike;
	}

	public double getTempMax(){
		return tempMax;
	}

	public int getSea_level(){
		return sea_level;
	}

	public int getGrnd_level(){
		return grnd_level;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	public void setSea_level(int sea_level) {
		this.sea_level = sea_level;
	}

	public void setGrnd_level(int grnd_level) {
		this.grnd_level = grnd_level;
	}

	@Override
	public String toString() {
		return "Main{" +
				"temp=" + temp +
				", tempMin=" + tempMin +
				", humidity=" + humidity +
				", pressure=" + pressure +
				", feelsLike=" + feelsLike +
				", tempMax=" + tempMax +
				", sea_level=" + sea_level +
				", grnd_level=" + grnd_level +
				'}';
	}
}