package com.zyt.orz.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyt.orz.common.api.CommonResult;
import com.zyt.orz.exception.ServiceException;
import com.zyt.orz.exception.ValidateException;

@ControllerAdvice
public class GloablExceptionHandler {

	@ResponseBody
	@ExceptionHandler(ValidateException.class)
	public CommonResult handleException(Exception e) {
		return CommonResult.validateFailed(e.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(ServiceException.class)
	public CommonResult handleException(ServiceException e) {
		return CommonResult.failed(e.getMessage());
	}
}
