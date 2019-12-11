package com.springboot.countryFlagApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.countryFlagApp.model.Continent;
import com.springboot.countryFlagApp.model.Country;
import com.springboot.countryFlagApp.service.CountryFlagProviderInterface;

/*  Controller class that takes input from the user through REST calls and talks to the service 
 * class to get the data from the JsonRepo class and send the requested data to the user. 
 */
@RestController
@RequestMapping("/flagApi")
public class CountryFlagController {

	@Autowired
	private CountryFlagProviderInterface countryFlagProviderInterface;

	/*  Controller class method to return all data from the json file as a list.
	 * @return: List(Continent Type) of continents, countries and flag as unicode characters. 
	 */
	@GetMapping("/getAllData")
	public List<Continent> getAllData() throws Exception{
		
		List<Continent> allData = countryFlagProviderInterface.getAllContinentData(); 		
		if(allData == null || allData.isEmpty()){
			throw new Exception("no data found");
		}
		else{
			return allData;
		}
		 
	}

	/*  Controller class method to return a list of countries and flags based on the given continent name. 
	 * @param : continentName(String), the name of the continent. Same as the path variable(marked with @PathVariable ) in @GetMapping.
	 * @return: List(Country Type) of countries and flag unicode characters.
	 */
	@GetMapping("/getFlags/{continentName}")
	public List<Country> getCountryFlagByContinentName(@PathVariable String continentName) throws Exception  {
		List<Country> countryObjectList = countryFlagProviderInterface.getFlagforEachCountryByContinentName(continentName);
		if(countryObjectList.isEmpty() || countryObjectList == null){			
			throw new Exception("countryObjectList is null or Empty");				
		}else{		
			return countryObjectList;
		}
	}

	/*  Controller class method to return countryFlag. 
	 * @param : continentName(String), the name of the continent, same as the path variable(marked with @PathVariable ) in @GetMapping.
	 * @param : countryName(String), the name of the country whose flag should be returned. Same as the path variable(marked with @PathVariable ) in @GetMapping.
	 * @return: Flag code(String), the flag of the countryName, as flag code. Eg. China:CN. 
	 */
	@GetMapping("/{continentName}/{countryName}")
	public String getFlagByCountryName(@PathVariable String continentName, @PathVariable String countryName) throws Exception{
		String countryFlag = countryFlagProviderInterface.getFlagByCountryName(continentName, countryName);
		if(countryFlag.isEmpty() || countryFlag == null){
			throw new Exception();
		}else{
			return countryFlag;
		}
	}
}
