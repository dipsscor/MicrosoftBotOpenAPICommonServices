package com.dipsscor.openapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dipsscor.model.location.IpAddressIPv6;
import com.dipsscor.model.location.Location;
import com.google.gson.Gson;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@Component
public class GeoLocationService {
	
	
	public List<String> getMyLocation() {
		

		Location location = getLocation();
		
		List<String> locationResponse = new ArrayList<String>();
		locationResponse.add("City: "+location.getCity().getName());
		locationResponse.add("State/Province: "+location.getArea().getName());
		locationResponse.add("Country: "+location.getCountry().getName());
		locationResponse.add("IP Address: "+location.getIp());
		locationResponse.add("Postal Code: "+location.getPostcode().toString());
		
		return locationResponse;
	}
	
	
	public Location getLocation() {
		
		//GET IPV6 address from seeip.org
		
		HttpResponse<String> ipaddress = Unirest.get("http://ip6.seeip.org/json")
				.asString();
		Gson ipAddressJson = new Gson();
		IpAddressIPv6 ipv6address = ipAddressJson.fromJson(ipaddress.getBody(), IpAddressIPv6.class);
		
		//GET LOCATION FROM RAPID OPEN APIS
		HttpResponse<String> response = Unirest.get("https://ip-geo-location.p.rapidapi.com/ip/"+ipv6address.getIp()+"?format=json")
				.header("x-rapidapi-host", "ip-geo-location.p.rapidapi.com")
				.header("x-rapidapi-key", "df5403a2femsh5e0cb583506948ep19acdcjsn23b568890fa2")
				.asString();
		
		Gson locationJson = new Gson();
		Location location = locationJson.fromJson(response.getBody(), Location.class);
		
		return location;
		
	}
	
	
}
