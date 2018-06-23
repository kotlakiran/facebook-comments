package com.kirankotla.facebook.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import facebook4j.internal.org.json.JSONException;

/**
 * Created by kreddykotla
 */
public interface FacebookServiceResource {

	@RequestMapping(method=RequestMethod.GET, value = "/serach", produces = { "application/json" })
	  public ResponseEntity<?> getFaceBookComments(@QueryParam("groupId") final String groupId,
			  @QueryParam("limit") final int limit,
			  @QueryParam("offset") final int offset,
			  @RequestHeader("Authorization") final String authorization,
			  @RequestHeader("ClientId") final String clientId,
			  @RequestHeader("ClientSecret") final String  clientSecret,
			  @Context HttpServletRequest httpRequest
			  ) throws JsonParseException, JsonMappingException, JSONException, IOException, Exception;
    
}


