package com.zyt.orz.config.dateconvert;

import java.sql.Timestamp;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ConverterTimestamp implements Converter<String,Timestamp>{

	@Override
	public Timestamp convert(String arg0) {
		if(!StringUtils.isEmpty(arg0.trim())){
			Timestamp timestamp=new Timestamp(Long.valueOf(arg0));
			return timestamp;
		}
		return null;
	}

}
