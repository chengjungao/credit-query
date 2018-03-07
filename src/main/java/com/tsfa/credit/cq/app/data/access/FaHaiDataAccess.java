package com.tsfa.credit.cq.app.data.access;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.tsfa.credit.cq.app.data.factory.ConnectFactory;
import com.tsfa.credit.cq.app.entity.request.FaHaiOption;
import com.tsfa.credit.cq.app.exception.BizException;

@Component
public class FaHaiDataAccess extends AbstractHttpDataAccess<FaHaiOption, JSONObject> {
	
	@Autowired
	@Qualifier("httpConnectFactory")
	private  ConnectFactory<HttpClient> factory;
	
	@Override
	public JSONObject query(FaHaiOption p) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("pname", p.getName());
			params.put("idcardNo", p.getIdCard());
			params.put("authCode", p.getAccessToken());
			String result = doGet(p.getUrl(),params);
			return JSONObject.parseObject(result);
		} catch (Exception e) {
			throw new BizException("访问法海数据源错误！");
		}
	}

	@Override
	protected HttpClient getClient(String url) {
		return factory.provide(url);
	}

}
