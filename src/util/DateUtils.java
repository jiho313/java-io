package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String toText(Date date) {
		if (date == null) {
			return "";
		}
		String formattedText = YYYYMMDD.format(date);
		return formattedText;
	}
	
	/**
	 * 날짜형식의 문자열을 {@code java.util.Date}로 변환해서 반환한다.
	 * @param text 문자열
	 * @return 날짜
	 */
	public static Date toDate(String text) {
		if (text == null) {
			return null;
		} try {
			return YYYYMMDD.parse(text);
		} catch (ParseException ex) {
			throw new RuntimeException("["+text+"]",ex);
		}
	}
}
