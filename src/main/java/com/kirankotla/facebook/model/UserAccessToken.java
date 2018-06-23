package com.kirankotla.facebook.model;

import java.io.Serializable;

public class UserAccessToken implements Serializable
{
  public String access_token;
  public String token_type;
  public  int expires_in;
  
  public String status;


  
public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public String getAccess_token() {
	return access_token;
}


public void setAccess_token(String access_token) {
	this.access_token = access_token;
}


public String getToken_type() {
	return token_type;
}


public void setToken_type(String token_type) {
	this.token_type = token_type;
}


public int getExpires_in() {
	return expires_in;
}


public void setExpires_in(int expires_in) {
	this.expires_in = expires_in;
}


@Override
public String toString() {
	return "UserAccessToken [access_token=" + access_token + ", token_type=" + token_type + ", expires_in=" + expires_in + ", status=" + status + "]";
}
  
  
}