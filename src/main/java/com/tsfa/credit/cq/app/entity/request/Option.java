package com.tsfa.credit.cq.app.entity.request;

public class Option {
	
	private String name;
	
	private String idCard;
	
	private int bizCode;
	
	public Option() {	}

	

	public Option(String name, String idCard, int bizCode) {
		this.name = name;
		this.idCard = idCard;
		this.bizCode = bizCode;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public ReqType getReqType() {
		return ReqType.parser(this.bizCode);
	}

	public int getBizCode() {
		return bizCode;
	}

	public void setBizCode(Integer bizCode) {
		this.bizCode = bizCode;
	}

}
