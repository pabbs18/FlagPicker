package com.springboot.countryFlagApp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Continent {

	//Name of the continent.
	String continent = null;
	
	//List of Country names and their flags
	List<Country> countries = null;	
	
	public Continent() {
		super();
	}

	public Continent(String continent, List<Country> countries) {
		super();
		this.continent = continent;
		this.countries = countries;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	
	
	
	
}
