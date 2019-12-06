package com.springboot.countryFlagApp.repo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.countryFlagApp.model.Continent;

@Component
/*
 * Get data from the json file to user  */
public class JsonDataRepo {
	
	List<Continent> ContinentData = new ArrayList<>();
	
	/*
	 *Gets the data as a stream of bytes from the json file.
	 *Maps the fields in json to POJO fields of Continent class using ObjectMapper .
	 *@return : json data as a list(Continent Type)
	 *  */
	public List<Continent> getContinentDataList() throws Exception{			
		ObjectMapper jsonToPojoObjectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<Continent>> continentListType = new TypeReference<List<Continent>>(){};
		InputStream continentJsonDataAsByteStream = TypeReference.class.getResourceAsStream("/json/continents.json");
		ContinentData = jsonToPojoObjectMapper.readValue(continentJsonDataAsByteStream, continentListType);			
		return ContinentData;
	}	
}
