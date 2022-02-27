package com.steelswans.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// A DTO class to store clouds data
public class Clouds{

	@JsonProperty("all")
	private int all;

	public int getAll(){
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	@Override
	public String toString() {
		return "Clouds{" +
				"all=" + all +
				'}';
	}
}