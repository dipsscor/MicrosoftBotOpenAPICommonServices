package com.dipsscor.controllers;

import com.dipsscor.creators.ActivityCreator;
import com.dipsscor.creators.ConversationCreator;
import com.dipsscor.senders.ResourceResponseSender;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;
import com.microsoft.bot.connector.ConnectorClient;
import com.microsoft.bot.connector.Conversations;
import com.microsoft.bot.connector.customizations.MicrosoftAppCredentials;
import com.microsoft.bot.connector.implementation.ConnectorClientImpl;
import com.microsoft.bot.schema.models.Activity;
import com.microsoft.bot.schema.models.ResourceResponse;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "V1.0/MicrosoftBotOpenAPICommonServices/api/messages")
public class BotMessagesHandler {

  @Autowired
  private MicrosoftAppCredentials credentials;

  @Autowired
  private List<ResourceResponse> responses;
  
  @Autowired
  ActivityCreator activityCreator;
  
  
  /**
   * REST API to handle the incomming messages
   * @param activity
   * @return
   */

  @PostMapping(path = "")
  public List<ResourceResponse> create(@RequestBody @Valid
  @JsonDeserialize(using = DateTimeDeserializer.class) Activity activity) {
    ConnectorClient connector =
        new ConnectorClientImpl(activity.serviceUrl(), credentials);
    
    Conversations conversation = ConversationCreator.createResponseConversation(connector);
    
    
    
    Activity echoActivity = ActivityCreator.createEchoActivity(activity);
    Activity spellCheckedActivity = ActivityCreator.createSpellCheckedActivity(activity);
    
    List<Activity> processedActivities;
    
    if(!spellCheckedActivity.text().equalsIgnoreCase("NO CORRECTION NEEDED")) {
	    ResourceResponse echoResponse =
	            ResourceResponseSender.send(conversation, activity, echoActivity);
	        responses.add(echoResponse);
	
	    ResourceResponse spellCheckedResponse =
	            ResourceResponseSender.send(conversation, activity, spellCheckedActivity);
	        responses.add(spellCheckedResponse);
	        
	    processedActivities = activityCreator.processIncomingRequest(spellCheckedActivity);    
        
        
    }else {
    	processedActivities = activityCreator.processIncomingRequest(activity);   
    }
    
    
    



    
    for(Activity processedActivity:processedActivities) {
        ResourceResponse processedResponse =
                ResourceResponseSender.send(conversation, activity, processedActivity);
            responses.add(processedResponse);
    }
    


    return responses;
  }
}
