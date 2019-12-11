package com.springboot.countryFlagApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

	//Name of the country
	String name;
	
	//Flag of the country
	String flag;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}
	
	public Country(String name, String flag) {
		super();
		this.name = name;
		this.flag = flag;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFlag() {
		return flag;
	}


	public void setCountryFlag(String flag) {
		this.flag = flag;
	}
	
	
}
