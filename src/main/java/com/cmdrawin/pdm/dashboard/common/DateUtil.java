package com.cmdrawin.pdm.dashboard.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	// 获得当天0点时间
	public static Date getTimesmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得当天24点时间
	public static Date getTimesnight() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得本周一0点时间
	public static Date getTimesWeekmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}

	// 获得本周日24点时间
	public static Date getTimesWeeknight() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesWeekmorning());
		cal.add(Calendar.DAY_OF_WEEK, 7);
		return cal.getTime();
	}

	// 获得本月第一天0点时间
	public static String getTimesMonthmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=longSdf.format(cal.getTime());
		return time;
	}

	// 获得本月最后一天24点时间
	public static String getTimesMonthnight() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 24);
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=longSdf.format(cal.getTime());
		return time;
	}
	
	// 获得上月第一天0点时间
	public static String getTimesLastMonthmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.add(Calendar.MONTH, -1);
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=longSdf.format(cal.getTime());
		return time;
	}

	// 获得上月最后一天24点时间
	public static String getTimesLastMonthnight() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.add(Calendar.MONTH, -1);
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=longSdf.format(cal.getTime());
		return time;
	}

	//本季度季度的开始时间
	public static String getCurrentQuarterStartTime() {

		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		String time="";
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				c.set(Calendar.MONTH, 1);
			else if (currentMonth >= 4 && currentMonth <= 6)
				c.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				c.set(Calendar.MONTH, 4);
			else if (currentMonth >= 10 && currentMonth <= 12)
				c.set(Calendar.MONTH, 9);
			c.set(Calendar.DATE, 1);
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time =shortSdf.format(c.getTime()) + " 00:00:00";
			now=shortSdf.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	//本机季度的结束时间
	public static String getCurrentQuarterEndTime() {
		
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		String time="";
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 2);
				c.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 8);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time=shortSdf.format(c.getTime()) + " 23:59:59";
			now=shortSdf.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	
	//本年的开始时间
	public static String getCurrentYearStartTime() {
		String time="";	
		try {
			Calendar c = Calendar.getInstance();

			int currentYear = c.get(Calendar.YEAR);
			time=currentYear+"-01-01 00:00:00";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	//本年的结束时间
	public static String getCurrentYearEndTime() {
		String time="";	
		try {
			Calendar c = Calendar.getInstance();

			int currentYear = c.get(Calendar.YEAR);
			time=currentYear+"-12-31 23:59:59";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	
	// 获得上月的结算起点时间（上上个月月末26号）
	public static String getTimesLastMonthmorning_cmd() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str_date="";
		try{

			Date date=longSdf.parse(getTimesLastMonthmorning());
			int month=date.getMonth();
			int amount=0;
			if(month==1||month==3||month==5||month==7||month==8||month==10||month==0)
				amount=-6;
			if(month==4||month==6||month==9||month==11)
				amount=-5;
			if(month==2)
				amount=-3;
			cal.setTime(date);
			cal.add(Calendar.DATE, amount);
			str_date=longSdf.format(cal.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}

		return str_date;
	}
	
	// 获得上月的结算结束时间（上个月月末25号）
	public static String getTimesLastMonthnight_cmd() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str_date="";
		try{

			Date date=longSdf.parse(getTimesLastMonthnight());
			int month=date.getMonth();
			int amount=0;
			if(month==1||month==3||month==5||month==7||month==8||month==10||month==0)
				amount=-6;
			if(month==4||month==6||month==9||month==11)
				amount=-5;
			if(month==2)
				amount=-3;
			cal.setTime(date);
			cal.add(Calendar.DATE, amount);
			str_date=longSdf.format(cal.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}

		return str_date;
	}
	
	// 获得本月结算的起始时间（上月月末26号）
	public static String getTimesMonthmorning_cmd() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str_date="";
		try{

			Date date=longSdf.parse(getTimesMonthmorning());
			int month=date.getMonth();
			int amount=0;
			if(month==1||month==3||month==5||month==7||month==8||month==10||month==0)
				amount=-6;
			if(month==4||month==6||month==9||month==11)
				amount=-5;
			if(month==2)
				amount=-3;
			cal.setTime(date);
			cal.add(Calendar.DATE, amount);
			str_date=longSdf.format(cal.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}

		return str_date;
	}

	// 获得本月结算的结束时间（本月月末的26号）
	public static String getTimesMonthnight_cmd() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str_date="";
		try{

			Date date=longSdf.parse(getTimesMonthnight());
			int month=date.getMonth();
			int amount=0;
			if(month==1||month==3||month==5||month==7||month==8||month==10||month==0)
				amount=-6;
			if(month==4||month==6||month==9||month==11)
				amount=-5;
			if(month==2)
				amount=-3;
			cal.setTime(date);
			cal.add(Calendar.DATE, amount);
			str_date=longSdf.format(cal.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}

		return str_date;
	}
	
	//获取当前时间
	public static String getCurrentTime(String pattern){
		String str_date="";
		try{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat Sdf = new SimpleDateFormat(pattern);
			str_date=Sdf.format(cal.getTime());
			return str_date;
		}catch(Exception e){
			e.printStackTrace();
		}
		return str_date;
	}

}
