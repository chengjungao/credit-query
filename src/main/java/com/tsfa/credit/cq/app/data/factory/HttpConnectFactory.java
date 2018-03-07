package com.tsfa.credit.cq.app.data.factory;


import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.stereotype.Component;

@Component
public class HttpConnectFactory implements ConnectFactory<HttpClient> {
	private static PoolingHttpClientConnectionManager cm; 
	private static Map<String, HttpClient> cahce = new HashMap<>();
  
    static {  
        // 设置连接池  
    	cm = new PoolingHttpClientConnectionManager();  
        // 设置连接池大小  
    	cm.setMaxTotal(100);  
    	cm.setDefaultMaxPerRoute(100);  
    	cm.setValidateAfterInactivity(10000);
    }  
    
    
	@Override
	public HttpClient provide(String url) {
		HttpClient httpClient = cahce.get(url);
		if (httpClient == null) {
			synchronized (cahce) {
				if (httpClient == null) {
					httpClient = HttpClients.custom()
			                .setConnectionManager(cm)
			                .build();
					cahce.put(url, httpClient);
				}
			}
		}
		return httpClient;
	}

}
