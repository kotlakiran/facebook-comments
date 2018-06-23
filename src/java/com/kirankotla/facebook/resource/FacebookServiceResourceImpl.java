package com.kirankotla.facebook.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kirankotla.facebook.service.FacebookService;

import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.internal.org.json.JSONException;

/**
 * Created by kreddykotla.
 */
@RestController
@RequestMapping("facebook")
public class FacebookServiceResourceImpl implements FacebookServiceResource{

    private static final Logger LOGGER = LoggerFactory.getLogger(FacebookServiceResourceImpl.class);

	@Autowired
	FacebookService facebookService;
    
	@Override
	public ResponseEntity<?> getFaceBookComments(String groupId,int offset,int limit,String accessToken,String clientSecret,String clientId,HttpServletRequest httpRequest) throws JsonParseException, JsonMappingException, JSONException, IOException, Exception {
		
		ResponseList<Post> posts=facebookService.getFaceBookComments(groupId,offset,limit,httpRequest.getHeader("Authorization"),httpRequest.getHeader("clientSecret"),httpRequest.getHeader("clientId"));
		  ObjectMapper mapper = new ObjectMapper();
		    mapper.setSerializationInclusion(Include.NON_NULL);
		    mapper.setSerializationInclusion(Include.NON_EMPTY);
		    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		 return ResponseEntity.ok(mapper.writeValueAsString(posts));
	}

   

}
