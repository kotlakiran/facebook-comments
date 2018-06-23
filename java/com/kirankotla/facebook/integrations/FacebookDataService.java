package com.kirankotla.facebook.integrations;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kirankotla.facebook.model.UserAccessToken;

import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONException;

public interface FacebookDataService {
	
	public UserAccessToken getOAuthUserAccessToken(String client_id,String client_secret,String fb_exchange_token) throws JSONException, JsonParseException, JsonMappingException, IOException;

	public AccessToken getAccessToken(String accessToken) throws Exception;

}
