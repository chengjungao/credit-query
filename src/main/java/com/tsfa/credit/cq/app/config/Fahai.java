package com.tsfa.credit.cq.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("fahai")
public class Fahai {
	private String token;
	private String enterpriseUrl;
	private String personUrl;
	
	public Fahai() {	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEnterpriseUrl() {
		return enterpriseUrl;
	}
	public void setEnterpriseUrl(String enterpriseUrl) {
		this.enterpriseUrl = enterpriseUrl;
	}
	public String getPersonUrl() {
		return personUrl;
	}
	public void setPersonUrl(String personUrl) {
		this.personUrl = personUrl;
	}
	
	
}
