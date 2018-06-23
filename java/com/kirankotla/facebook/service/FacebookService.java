package com.kirankotla.facebook.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.internal.org.json.JSONException;

/**
 * Created by kreddykotla
 */
public interface FacebookService {
	
	 public ResponseList<Post> getFaceBookComments(String groupId,int offset,int limit,String authorization,String clientSecret,String clientId) throws JsonParseException, JsonMappingException, JSONException, IOException, Exception;
}
