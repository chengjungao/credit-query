package com.tsfa.credit.cq.app.entity.request;

import com.tsfa.credit.cq.app.exception.BizException;

public enum ReqType {
	Personal(1),
	
	Enterprise(2);
	
	private int code;

	private ReqType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static ReqType parser(int code){
		switch (code) {
		case 1:
			return Personal;
		case 2:
			return Enterprise;
		default:
			throw new BizException("解析业务类型异常，请传值  1 - 个人 ， 2 - 企业");
		}
	}
	
}
