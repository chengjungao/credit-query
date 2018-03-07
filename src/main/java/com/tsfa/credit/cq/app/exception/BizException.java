package com.tsfa.credit.cq.app.exception;

/**
 * 功能描述：业务异常类
 * @time 2018-03-05
 */
public class BizException extends RuntimeException{
	private static final long serialVersionUID = 4416586651712232070L;

	public BizException() {
		super();
	}

	public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(String message) {
		super(message);
	}

	public BizException(Throwable cause) {
		super(cause);
	}
	
}
