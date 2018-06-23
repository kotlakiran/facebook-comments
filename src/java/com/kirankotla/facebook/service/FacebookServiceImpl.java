package com.kirankotla.facebook.service;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kirankotla.facebook.integrations.FacebookDataService;
import com.kirankotla.facebook.model.UserAccessToken;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONException;

/**
 * Created by kreddykotla
 */
@Service
public class FacebookServiceImpl implements FacebookService {

	/*@Value("${facebook.clientId}")
	private String clientId;

	@Value("${facebook.clientSecret}")
	private String clientSecret;

	@Value("${facebook.fbExchangeToken}")
	private String fbExchangeToken;*/

	@Autowired
	FacebookDataService facebookDataService;

	@Override
	public ResponseList<Post> getFaceBookComments(String groupId,int offset,int limit,String accessToken,String clientSecret,String clientId) throws Exception {

		//UserAccessToken userAccessToken = facebookDataService.getOAuthUserAccessToken(clientId, clientSecret, fbExchangeToken);
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId(clientId,clientSecret);
		   
		facebook.setOAuthAccessToken(facebookDataService.getAccessToken(accessToken));

		ResponseList<Post> posts = facebook.getPosts(groupId, new Reading().limit(limit).offset(offset).fields("comments"));
		return posts;
	}

}
