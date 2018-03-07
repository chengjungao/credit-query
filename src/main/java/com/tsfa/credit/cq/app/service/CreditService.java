package com.tsfa.credit.cq.app.service;

import java.util.List;

import com.tsfa.credit.cq.app.entity.Credit;
import com.tsfa.credit.cq.app.entity.request.Option;

public interface CreditService {
	
	/**
	 * 功能描述：用于查询个人征信列表
	 * @param p
	 * @return
	 */
	public List<Credit> listCredit(Option p);
	
}
