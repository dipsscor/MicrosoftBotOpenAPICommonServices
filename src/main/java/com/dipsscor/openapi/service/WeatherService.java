package com.dipsscor.openapi.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.dipsscor.model.weather.WeatherMain;
import com.google.gson.Gson;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@Component
public class WeatherService {
	

	 
	
	public List<String> getWeatherDetails(String _city){
		
		//GET WEATHER FROM OPEN WEATHER MAP APIS
		HttpResponse<String> weatherOpenApiResponse = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+_city.trim()+"&appid=23d8c6a29eb186133a99f231900dcfd5&units=metric")
				.asString();
		
		Gson weatherJson = new Gson();
		WeatherMain weatherMain = weatherJson.fromJson(weatherOpenApiResponse.getBody(), WeatherMain.class);
		
		List<String> weatherResponse = new ArrayList<String>();
		weatherResponse.add("Weather Condition: "+weatherMain.getWeather()[0].getDescription());
		weatherResponse.add("Current Temperature: "+weatherMain.getMain().getTemp()+" °C");
		weatherResponse.add("Maximum Temperature: "+weatherMain.getMain().getTemp_max()+" °C");
		weatherResponse.add("Minimum Temperature: "+weatherMain.getMain().getTemp_min()+" °C");
		weatherResponse.add("Humidity: "+weatherMain.getMain().getHumidity());

		
		return weatherResponse;
		
	}
	
	
}
