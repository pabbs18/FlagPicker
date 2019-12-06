package spring;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.springboot.countryFlagApp.CountryFlagPickerApplication;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= CountryFlagPickerApplication.class)
public class CountryFlagPickerApplicationTests {

	@SuppressWarnings("deprecation")
	@Test
	public void getAllDataTest() throws URISyntaxException{
		final String url = "http://localhost:8080/flagApi/getAllData";
		
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(url);
		
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		Assert.assertEquals(200, responseEntity.getStatusCodeValue() );
		Assert.assertEquals(true, responseEntity.getBody().contains("continent"));
		Assert.assertEquals(true, responseEntity.getBody().contains("countries"));	
	}
	
	@Test
	public void getCountryFlagByContinentNameTest() throws URISyntaxException{
		final String url = "http://localhost:8080/flagApi/getFlags/Africa";
		
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(url);
		
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
		Assert.assertEquals(true, responseEntity.getBody().contains("name"));
		Assert.assertEquals(true, responseEntity.getBody().contains("flag"));		
	}
	
	@Test
	public void getFlagByCountryNameTest() throws URISyntaxException{
		final String url = "http://localhost:8080/flagApi/Asia/China";
		
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(url);
		
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
		Assert.assertEquals(false, responseEntity.getBody().contains("🇦🇨"));
	}

}
