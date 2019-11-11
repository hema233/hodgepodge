package com.zyt.orz.config.dateconvert;

import java.sql.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ConverterDate implements Converter<String,Date>{

	@Override
	public Date convert(String arg0) {
		if(!StringUtils.isEmpty(arg0.trim())){
			Date timestamp=new Date(Long.valueOf(arg0));
			return timestamp;
		}
		return null;
	}
	

}
