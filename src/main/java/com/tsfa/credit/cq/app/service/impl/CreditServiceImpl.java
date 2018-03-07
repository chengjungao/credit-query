package com.tsfa.credit.cq.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsfa.credit.cq.app.data.handler.DataHandler;
import com.tsfa.credit.cq.app.entity.Credit;
import com.tsfa.credit.cq.app.entity.request.Option;
import com.tsfa.credit.cq.app.repository.CreditRepository;
import com.tsfa.credit.cq.app.service.CreditService;

/**
 * 功能描述：获取征信数据
 * @time 2018-03-05
 */
@Service
public class CreditServiceImpl implements CreditService{
	
	@Autowired
	private CreditRepository creditRepository;
	
	@Autowired
	private Map<String, DataHandler<?,?>> handlers;
	
	@Override
	public List<Credit> listCredit(Option p) {
		List<Credit>  credits = creditRepository.findAllByIdCard(p.getName(), p.getIdCard(),p.getReqType().getCode());
		if (credits == null || credits.isEmpty()) {
			credits = new ArrayList<>();
			Credit credit = new Credit();
			credit.setBizCode(p.getBizCode());
			credit.setPname(p.getName());
			credit.setIdCard(p.getIdCard());
			credits.add(credit);
			for (Entry<String, DataHandler<?,?>> entry : handlers.entrySet()) {
				entry.getValue().handle(p, credits);
			}
		}
		creditRepository.save(credits);
		return credits;
	}

}
