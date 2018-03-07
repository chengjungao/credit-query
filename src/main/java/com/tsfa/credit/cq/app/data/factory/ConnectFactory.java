package com.tsfa.credit.cq.app.data.factory;

/**
 * 功能描述：http client 工厂
 *
 * @param <T>
 */
public interface ConnectFactory<T> {
	
	public T provide(String url);
}
