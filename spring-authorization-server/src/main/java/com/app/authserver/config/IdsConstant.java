package com.app.authserver.config;

public enum IdsConstant {
	
	
	CLIENT_CREDENTIALS("client_credentials"),
	
	RESOURCE_SERVER_READ("resource-server-read"),RESOURCE_SERVER_WRITE("resource-server-write"), 
	
	PASSWORD("password"),
	
	REFRESH_TOKEN("refresh_token"),
	
	AUTHORIZATION_CODE("authorization_code"),
	
	WRITE("write"),READ("read");

	private String value;

	IdsConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
