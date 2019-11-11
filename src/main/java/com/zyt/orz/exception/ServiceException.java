package com.zyt.orz.exception;

/**
 * @author lei.zhao
 *	业务逻辑异常
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String msg) {
		super(msg);
	}

}
