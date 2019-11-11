package com.zyt.orz.config.dateconvert;

import java.io.IOException;
import java.sql.Timestamp;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class TimestampToLong extends JsonSerializer<Timestamp>{

	@Override
	public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeNumber(value.getTime());
	}

}
