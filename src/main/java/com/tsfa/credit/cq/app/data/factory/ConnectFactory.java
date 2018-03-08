package com.tsfa.credit.cq.app.data.factory;

/**
 * 功能描述： client 工厂
 *
 * @param <T>
 */
public interface ConnectFactory<T> {
	
	public T provide(String url);
}
