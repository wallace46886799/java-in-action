package com.dreamslab.lang;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;


public class DateUtilsTest{
		
	 	@Test
	    public void testFormat() throws Exception {
	 		//DateUtils.
	 		
	 		Date d = new Date(99,8,20);
	 		String a = DateFormatUtils.format(d, "yyyy");
	 		String b = DateFormatUtils.format(d, "M");
	 		String c = DateFormatUtils.format(d, "MM");
	 		
	 		System.out.println(a);
	 		System.out.println(b);
	 		System.out.println(c);
	    }
}
