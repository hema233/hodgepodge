package com.zyt.orz.config.dateconvert;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class LocalDateTimeToLong extends JsonSerializer<LocalDateTime>{

	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeNumber(value.toInstant(ZoneOffset.of("+8")).toEpochMilli());
	}

}
