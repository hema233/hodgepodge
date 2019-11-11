package com.zyt.orz.config.dateconvert;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author lei.zhao 转换时间戳为LocalDateTime
 */
@Component
public class ConverterLocalDateTime implements Converter<String, LocalDateTime> {

	@Override
	public LocalDateTime convert(String arg0) {
		if (!StringUtils.isEmpty(arg0.trim())) {
			LocalDateTime timestamp = LocalDateTime.ofEpochSecond(Long.valueOf(arg0) / 1000, 0, ZoneOffset.ofHours(8));
			return timestamp;
		}
		return null;
	}

}
