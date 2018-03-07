package com.tsfa.credit.cq.app.data.access;

/**
 * 功能描述：用于访问第三方数据源
 * @time 2018-03-05 
 */
public interface DataAccess<P,R> {
	
	/**
	 * @param p
	 * @return
	 */
	public R query(P p);
	
	
}
