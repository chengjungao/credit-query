package com.tsfa.credit.cq.app.data.access;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.tsfa.credit.cq.app.exception.BizException;

public abstract class AbstractHttpDataAccess<P,R> implements DataAccess<P,R> {
	private static RequestConfig requestConfig;  
	private static final int MAX_TIMEOUT = 7000;
	 
	static {
		
		RequestConfig.Builder configBuilder = RequestConfig.custom();  
        // 设置连接超时  
        configBuilder.setConnectTimeout(MAX_TIMEOUT);  
        // 设置读取超时  
        configBuilder.setSocketTimeout(MAX_TIMEOUT);  
        // 设置从连接池获取连接实例的超时  
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);  
        // 在提交请求之前 测试连接是否可用  
        requestConfig = configBuilder.build();
	}
	
	
	/**
	 * @param url
	 * @return
	 */
	protected abstract HttpClient getClient(String url);
	
	
	/**
	 * @param url
	 * @param params
	 * @return
	 */
    public String doGet(String url, Map<String, Object> params) {  
        String apiUrl = url;  
        StringBuffer param = new StringBuffer();  
        int i = 0;  
        if(params != null && !params.isEmpty()){
	        for (String key : params.keySet()) {  
	            if (i == 0)  
	                param.append("?");  
	            else  
	                param.append("&");  
	            param.append(key).append("=").append(params.get(key));  
	            i++;  
	        } 
        }
        apiUrl += param;  
        HttpClient httpclient = getClient(url);  
        try {  
            HttpGet get = new HttpGet(apiUrl);  
            HttpResponse response = httpclient.execute(get);  
            HttpEntity entity = response.getEntity();  
           return EntityUtils.toString(entity);
        } catch (IOException e) {  
           throw new BizException("http query error!",e);
        }  
    }  
    
    
    /**
     * @param url
     * @param params
     * @return
     */
    public String doPost(String url, Map<String, Object> params) {  
        HttpClient httpClient = getClient(url);
        HttpPost httpPost = new HttpPost(url);  
        try {  
            httpPost.setConfig(requestConfig);  
            List<NameValuePair> pairList = new ArrayList<>(params.size());  
            for (Map.Entry<String, Object> entry : params.entrySet()) {  
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry  
                        .getValue().toString());  
                pairList.add(pair);  
            }  
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));  
            HttpResponse response = httpClient.execute(httpPost);  
            HttpEntity entity = response.getEntity();  
            return EntityUtils.toString(entity, "UTF-8");  
        } catch (IOException e) {  
        	throw new BizException("http query error!",e);
        } 
    }  
}
