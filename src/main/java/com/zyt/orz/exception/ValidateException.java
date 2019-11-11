package com.zyt.orz.exception;

/**
 * @author lei.zhao
 *	数据验证异常
 */
public class ValidateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidateException(String msg) {
		super(msg);
	}

}
