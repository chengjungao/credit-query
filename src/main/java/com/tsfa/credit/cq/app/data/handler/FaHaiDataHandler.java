package com.tsfa.credit.cq.app.data.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.tsfa.credit.cq.app.config.DataAccessConfig;
import com.tsfa.credit.cq.app.data.access.DataAccess;
import com.tsfa.credit.cq.app.entity.Credit;
import com.tsfa.credit.cq.app.entity.request.FaHaiOption;
import com.tsfa.credit.cq.app.entity.request.Option;
import com.tsfa.credit.cq.app.entity.request.ReqType;

@Component
public class FaHaiDataHandler extends AbstractDataHandler<JSONObject,FaHaiOption>{

	@Autowired
	@Qualifier("faHaiDataAccess")
	private DataAccess<FaHaiOption, JSONObject> dataAccess;
	
	@Autowired
	private DataAccessConfig dataAccessConfig;

	@Override
	public FaHaiOption generateOption(Option option) {
		FaHaiOption faHaiOption = new  FaHaiOption();
		faHaiOption.setAccessToken(dataAccessConfig.getFahai().getToken());
		faHaiOption.setIdCard(option.getIdCard());
		faHaiOption.setName(option.getName());
		faHaiOption.setBizCode(option.getBizCode());
		if (option.getReqType() == ReqType.Enterprise) {
			faHaiOption.setUrl(dataAccessConfig.getFahai().getEnterpriseUrl());
		}else{
			faHaiOption.setUrl(dataAccessConfig.getFahai().getPersonUrl());
		}
		return faHaiOption;
	}

	@Override
	public JSONObject fetchData(FaHaiOption p) {
		return dataAccess.query(p);
	}

	@Override
	protected void process(JSONObject r, List<Credit> credits) {
		credits.get(0).setContent(r.toJSONString());
	}

	
}
