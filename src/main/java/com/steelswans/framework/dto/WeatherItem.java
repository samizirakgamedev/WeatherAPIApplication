package com.steelswans.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// A DTO class to store weather type data
public class WeatherItem{

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("description")
	private String description;

	@JsonProperty("main")
	private String main;

	@JsonProperty("id")
	private int id;

	public String getIcon(){
		return icon;
	}

	public String getDescription(){
		return description;
	}

	public String getMain(){
		return main;
	}

	public int getId(){
		return id;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WeatherItem{" +
				"icon='" + icon + '\'' +
				", description='" + description + '\'' +
				", main='" + main + '\'' +
				", id=" + id +
				'}';
	}
}