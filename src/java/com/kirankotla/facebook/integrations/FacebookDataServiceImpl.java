package com.kirankotla.facebook.integrations;
import facebook4j.*;
import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.ws.rs.BadRequestException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.kirankotla.facebook.model.UserAccessToken;

@Service
public class FacebookDataServiceImpl implements FacebookDataService {
	@Override
	public UserAccessToken getOAuthUserAccessToken(String client_id, String client_secret, String fb_exchange_token) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
		String url = "https://graph.facebook.com/oauth/access_token";
			Facebook facebook = new FacebookFactory().getInstance();
			UserAccessToken userAccessToken=null;
				  RestTemplate resttemplate=new RestTemplate();
			       
					UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
					        .queryParam("client_id",client_id)
					        .queryParam("client_secret",client_secret)
					        .queryParam("fb_exchange_token", fb_exchange_token)
					        .queryParam("grant_type","fb_exchange_token");
					 Gson gson = new GsonBuilder().disableHtmlEscaping().create();
					 Object object= null;
					 try {
					  object= resttemplate.getForObject(builder.toUriString(),Object.class);
					 }
					 catch (Exception e) {
					throw new BadRequestException();
					}
					JSONObject json = new JSONObject(gson.toJson(object));
					userAccessToken=new ObjectMapper().readValue(gson.toJson(object),UserAccessToken.class);
						
		return userAccessToken;
	}

	@Override
	public AccessToken getAccessToken(String userAccessToken) throws Exception {
		return new AccessToken(userAccessToken);
	}
       

}