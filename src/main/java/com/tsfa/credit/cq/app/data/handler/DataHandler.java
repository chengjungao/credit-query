package com.tsfa.credit.cq.app.data.handler;

import java.util.List;

import com.tsfa.credit.cq.app.entity.Credit;
import com.tsfa.credit.cq.app.entity.request.Option;

/**
 * 用于数据处理接口
 * @param <R>
 */
public interface DataHandler<R,P> {
	
	/**
	 * @param jsonStr
	 * @return
	 */
	public void handle(Option option,List<Credit> credits);
	
	public P generateOption(Option option);
	
	public R fetchData(P p);
}
