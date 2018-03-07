package com.tsfa.credit.cq.app.data.handler;

import java.util.List;

import com.tsfa.credit.cq.app.entity.Credit;
import com.tsfa.credit.cq.app.entity.request.Option;

public abstract class AbstractDataHandler<R, P extends Option> implements DataHandler<R, P> {

	@Override
	final public void handle(Option option, List<Credit> credits) {
		P p = generateOption(option);
		R r = fetchData(p);
		process(r,credits);
	}
	
	protected abstract void process(R r , List<Credit> credits);
}
