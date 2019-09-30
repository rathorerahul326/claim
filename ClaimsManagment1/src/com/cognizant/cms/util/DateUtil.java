package com.cognizant.cms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) throws Exception
	{
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = simpleDateFormat.parse(date);
		return date1;
	}
}
