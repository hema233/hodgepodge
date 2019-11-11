package com.zyt.orz.config.dateconvert;

import java.io.IOException;
import java.sql.Date;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class DateToLong extends JsonSerializer<Date>{

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeNumber(value.getTime());
	}

}
