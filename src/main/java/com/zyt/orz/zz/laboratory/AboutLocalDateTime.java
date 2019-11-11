package com.zyt.orz.zz.laboratory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class AboutLocalDateTime {
	public static void main(String[] args) {
		Long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
		LocalDateTime time2 = LocalDateTime.ofEpochSecond(timestamp / 1000, 0, ZoneOffset.ofHours(8));
		System.out.println(time2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS")));
	}
}
