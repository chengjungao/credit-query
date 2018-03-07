package com.tsfa.credit.cq.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "data-access")
@Component
public class DataAccessConfig {
	
	private Fahai fahai;
	
	
	public DataAccessConfig() {	}

	public Fahai getFahai() {
		return fahai;
	}

	public void setFahai(Fahai fahai) {
		this.fahai = fahai;
	}
	
	
}
