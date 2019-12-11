package com.springboot.countryFlagApp.service;

import java.util.List;
import org.springframework.stereotype.Component;

import com.springboot.countryFlagApp.model.Continent;
import com.springboot.countryFlagApp.model.Country;

/*  Service Interface that provides methods to be implemented by the implementing service class. 
 */
@Component
public interface CountryFlagProviderInterface {

	public List<Continent> getAllContinentData();
	public List<Country> getFlagforEachCountryByContinentName(String continentName);
	public String getFlagByCountryName(String continentName, String countryName);
}
