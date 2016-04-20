package com.zgld.api.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {
	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static Date strDateTimeToDate(String strDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date strtodate = formatter.parse(strDate);
		return strtodate;
	}

	public static String dateToStrLong(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	public static String dateToStr(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static Date getNow() {
		Date currentTime = new Date();
		return currentTime;
	}

	public static Date getLastDate(long day) {
		Date date = new Date();
		long date_3_hm = date.getTime() - 122400000L * day;
		Date date_3_hm_date = new Date(date_3_hm);
		return date_3_hm_date;
	}

	public static String getStringToday() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getHour() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);

		String hour = dateString.substring(11, 13);
		return hour;
	}

	public static String getTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);

		String min = dateString.substring(14, 16);
		return min;
	}

	public static String getUserDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date date1 = format.parse(sj1);
			long Time = date1.getTime() / 1000L + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000L);
			mydate1 = format.format(date1);
		} catch (Exception localException) {
		}
		return mydate1;
	}

	public static String getNextDay(String nowdate, String delay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String mdate = "";
			Date d = strToDate(nowdate);
			long myTime = d.getTime() / 1000L + Integer.parseInt(delay) * 24 * 60 * 60;
			d.setTime(myTime * 1000L);
			return format.format(d);
		} catch (Exception e) {
		}
		return "";
	}

	public static boolean isLeapYear(String ddate) {
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(1);
		if (year % 400 == 0)
			return true;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				return false;
			}
			return true;
		}
		return false;
	}

	public static String getEDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(str, pos);
		String j = strtodate.toString();
		String[] k = j.split(" ");
		return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	}

	public static String getEndDateOfMonth(String dat) {
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if ((mon == 1) || (mon == 3) || (mon == 5) || (mon == 7) || (mon == 8) || (mon == 10) || (mon == 12))
			str = str + "31";
		else if ((mon == 4) || (mon == 6) || (mon == 9) || (mon == 11)) {
			str = str + "30";
		} else if (isLeapYear(dat))
			str = str + "29";
		else {
			str = str + "28";
		}

		return str;
	}

	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(1) - cal2.get(1);
		if (subYear == 0) {
			if (cal1.get(3) == cal2.get(3))
				return true;
		} else if ((1 == subYear) && (11 == cal2.get(2))) {
			if (cal1.get(3) == cal2.get(3))
				return true;
		} else if ((-1 == subYear) && (11 == cal1.get(2)) && (cal1.get(3) == cal2.get(3))) {
			return true;
		}
		return false;
	}

	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(3));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(1));
		return year + week;
	}

	public static String getWeek(String sdate, String num) {
		Date dd = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		if (num.equals("1"))
			c.set(7, 2);
		else if (num.equals("2"))
			c.set(7, 3);
		else if (num.equals("3"))
			c.set(7, 4);
		else if (num.equals("4"))
			c.set(7, 5);
		else if (num.equals("5"))
			c.set(7, 6);
		else if (num.equals("6"))
			c.set(7, 7);
		else if (num.equals("0"))
			c.set(7, 1);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	public static String getWeek(String sdate) {
		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static String getWeekStr(String sdate) {
		String str = "";
		str = getWeek(sdate);
		if ("1".equals(str))
			str = "星期日";
		else if ("2".equals(str))
			str = "星期一";
		else if ("3".equals(str))
			str = "星期二";
		else if ("4".equals(str))
			str = "星期三";
		else if ("5".equals(str))
			str = "星期四";
		else if ("6".equals(str))
			str = "星期五";
		else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	public static long getDays(String date1, String date2) {
		if ((date1 == null) || (date1.equals("")))
			return 0L;
		if ((date2 == null) || (date2.equals(""))) {
			return 0L;
		}
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception localException) {
		}
		long day = (date.getTime() - mydate.getTime()) / 86400000L;
		return day;
	}

	public static String order_no() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static void main(String[] args) throws Exception {
	}
}