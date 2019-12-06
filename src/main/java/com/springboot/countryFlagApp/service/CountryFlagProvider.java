package com.springboot.countryFlagApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.countryFlagApp.model.Continent;
import com.springboot.countryFlagApp.model.Country;
import com.springboot.countryFlagApp.repo.JsonDataRepo;

/*  Service class that talks to the JsonRepo class to get data from the json file. 
 */
@Service
public class CountryFlagProvider implements CountryFlagProviderInterface {

	@Autowired
	private JsonDataRepo jsonDataRepo;
	
	
	/*  Service class method to return all data from the json file as a list 
	 * @return: List(Continent Type) of continents, countries and flag as unicode characters, 
	 */
	@Override
	public List<Continent> getAllContinentData()  {
		List<Continent> continentDataList = null;
		try {
			
			continentDataList = jsonDataRepo.getContinentDataList();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return continentDataList;
		
	}
	
	/*  Service class method to return a list of countries and flags based on the given continent name 
	 * @param : continentName(String), the name of the continent
	 * @return: List(Country Type) of countries and flag unicode characters, 
	 */
	@Override
	public List<Country> getFlagforEachCountryByContinentName(String continentName) {
		
		List<Continent> continentDataList = null;
		List<Country> countryListObject = null;		
		try {
			continentDataList = jsonDataRepo.getContinentDataList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Continent continent: continentDataList){
			
			if(continent.getContinent().equals(continentName)){
				countryListObject = continent.getCountries();
				break;
			}
		}
		return countryListObject;
	}

	/*  Service class method to return countryFlag 
	 * @param : continentName(String), the name of the continent
	 * @param : countryName(String), the name of the country whose flag should be returned
	 * @return: Flag code(String), the flag of the countryName, as flag code. Eg. China:CN 
	 */	
	@Override
	public String getFlagByCountryName(String continentName, String countryName) {
		
		List<Continent> continentDataList = null;
		List<Country> countryListObject = null;
		String countryFlag = null;
		try {
			continentDataList = jsonDataRepo.getContinentDataList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Continent continent: continentDataList){
			if(continent.getContinent().equals(continentName)){
				countryListObject = continent.getCountries();
				break;
			}
		}
		for(Country country: countryListObject){
			if(country.getName().equals(countryName)){
			  countryFlag = country.getFlag();
				break;
			}
		}		
		return countryFlag;
	}
}
