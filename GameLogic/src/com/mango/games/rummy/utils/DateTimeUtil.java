package com.mango.games.rummy.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil 
{
	public static long GetDateDiff(String date1, String date2)
	{
       long diffOfDays = GetDateDiffInMins(date1, date2) / (60 * 24);
        
       return Math.abs(diffOfDays);
	}
	
	public static long GetDateDiffInMins(String date1, String date2)
	{
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
        Date newDate1 = new Date();
        Date newDate2 = new Date();
        
        try
		{
			newDate1 = (Date) dateFormat.parse(date1);
			newDate2 = (Date) dateFormat.parse(date2);
		}
		catch(ParseException e)
		{
			System.out.println("Date Exception");
		}
		
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        // Set the date for both of the calendar to get difference
        cal1.setTime(newDate1);
        cal2.setTime(newDate2);
                
        // Get date in milliseconds
        long milisecond1 = cal1.getTimeInMillis();
        long milisecond2 = cal2.getTimeInMillis();

        // Find date difference in milliseconds
        long diffInMSec = milisecond2 - milisecond1;
        
        long diffInMins =  diffInMSec / (60 * 1000);
        
        return Math.abs(diffInMins);
	}
	
	public static String GetTodaysDate()
	{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		return dateFormat.format(cal.getTime());
	}
	
	public static String GetCurrentHour()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String s = sdf.format(new Date());
		String arr[] = s.split(":");
		
		String val = arr[0] + ":00";
        return val;
	}
	
	public static long DaysBetween(String date1, String date2) 
	{  
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
        Date newDate1 = new Date();
        Date newDate2 = new Date();
        
        try
		{
			newDate1 = (Date) dateFormat.parse(date1);
			newDate2 = (Date) dateFormat.parse(date2);
		}
		catch(ParseException e)
		{
			System.out.println("Date Exception");
		}
		
	    Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.setTime(newDate1);
        cal2.setTime(newDate2);
        
        return DaysBetween(cal1, cal2);
	}
	
	public static long DaysBetween(Calendar startDate, Calendar endDate) 
	{
		Calendar date = (Calendar) startDate.clone();  
		long daysBetween = 0;  
		
		while(date.before(endDate)) 
		{	  
			date.add(Calendar.DAY_OF_MONTH, 1);  
			daysBetween++;  
		}
		
		return daysBetween;  
	}
	
	public static String GetCurrentTimeStamp()
	{
		Calendar cal = Calendar.getInstance();
		return DateFormat.getInstance().format(cal.getTime());
	}
	
	public static String GetCurrentTimeStampinEpoch()
	{
		Calendar cal = Calendar.getInstance();		
		return DateFormat.getInstance().format(cal.getTimeInMillis());
	}
	
	public static boolean IsThisTime(String hour)
	{
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		
		try 
		{
			Date thisHour = parser.parse(hour);
			Date currentHour = parser.parse(GetCurrentHour());
			
			if(thisHour.equals(currentHour))
			{
				return true;
			}
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}

		return false;
	}
}
