/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Utility class
 */
package com.gadreel.lecture.schedule.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * Converts any given patterned string to a date object
	 * @param dateStr patterned date string
	 * @return a Date object
	 */
	public static Date stringToDate(String dateStr){
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
		
	}
	
	/**
	 * Converts any given date object to a patterned string.
	 * @param date date object
	 * @return a patterned date string 
	 */
	public static String dateToString(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		return df.format(date);
	}
}
