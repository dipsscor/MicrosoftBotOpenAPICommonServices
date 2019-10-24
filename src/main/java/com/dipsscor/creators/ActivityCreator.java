package com.dipsscor.creators;

import com.dipsscor.jazzyspellcheck.JazzySpellChecker;
import com.dipsscor.openapi.service.GeoLocationService;
import com.dipsscor.openapi.service.WeatherService;
import com.microsoft.bot.schema.models.Activity;
import com.microsoft.bot.schema.models.ActivityTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class ActivityCreator {

  private static final String spellCheckedResponsePart = "You have probably meant: ";
  private static final String echoResponsePart = "You typed: ";
  private static JazzySpellChecker spellChecker = new JazzySpellChecker();

  private ActivityCreator() {

  }
  
  
  // LOAD DATA
	static List<String> weatherUtterances = new ArrayList<String>();
	static List<String> locationUtterances = new ArrayList<String>();
	 static {

		    try {		      
			      Scanner sc = new Scanner(new ClassPathResource("weather-utterances.txt").getFile());
			      while(sc.hasNext()){
				       String line = sc.nextLine(); 
				       weatherUtterances.add(line);
			      }
			      
			      sc = new Scanner(new ClassPathResource("location-utterances.txt").getFile());
			      while(sc.hasNext()){
				       String line = sc.nextLine(); 
				       locationUtterances.add(line);
			      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	 }
  
  
  @Autowired
  GeoLocationService geoLocationConnector;
  
  @Autowired
  WeatherService weatherService;
  
  
  public static Activity createSpellCheckedActivity(Activity activity) {
	  
	String correctedText = spellChecker.getCorrectedText(activity.text()); 
	if(!correctedText.trim().equalsIgnoreCase(activity.text())) {
	    return createEmptyActivity(activity)
	            .withText(spellCheckedResponsePart + spellChecker.getCorrectedText(activity.text()));
	}else {
	    return createEmptyActivity(activity)
	            .withText("NO CORRECTION NEEDED");
	}

  }

  public static Activity createEchoActivity(Activity activity) {
    return createEmptyActivity(activity)
        .withText(echoResponsePart + activity.text());
  }
  
  
  
  /**
   * This method processes the incomming user requests.
   * @param activity
   * @return
   */
  public List<Activity> processIncomingRequest(Activity activity) {
	  
	  List<Activity> activities = new ArrayList<Activity>();
	   
	  
	  // LOCATION SERVICE
	  if(isWordMatched(activity.text().toLowerCase(), locationUtterances) ) {
		  
		  List<String> locationResponses = geoLocationConnector.getMyLocation();
		  
		  for(String locationResponse:locationResponses) {
			  activities.add(createEmptyActivity(activity).withText(locationResponse));
		  }
		  
		  return activities;
			  
	  }
	  // WEATHER SERVICE
	  else if(isWordMatched(activity.text().toLowerCase(), weatherUtterances)) {
		  
		  String city = geoLocationConnector.getLocation().getCity().getName();
		  List<String> weatherResponses = weatherService.getWeatherDetails(city);
		  
		  for(String weatherResponse:weatherResponses) {
			  activities.add(createEmptyActivity(activity).withText(weatherResponse));
		  }
		  
		  return activities;
		  
	  }	  
	  
	  else {
		  activities.add(createEmptyActivity(activity).withText("Sorry I am not trained to get this request"));
		  return activities;
	  }
	  
  }

  
  
  
  
  
  private static Activity createEmptyActivity(Activity activity) {
    return new Activity()
        .withType(ActivityTypes.MESSAGE)
        .withRecipient(activity.from())
        .withFrom(activity.recipient());
  }
  
  
  private boolean isWordMatched(String _text,List<String> _values) {
	  for(String value: _values) {
		  if(_text.contains(value)) {
			  return true;
		  }
	  }
	  return false;
  }
}
