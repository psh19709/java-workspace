package day21.format;

import java.util.Date;

import utils.StringUtils;

public class StrinUtilsApp {
	
	public static void main(String[] args) {
		
		Date date1 = StringUtils.textToDate("2022-09-30");
		System.out.println(date1);
		Date date2 = StringUtils.textToDate("2022년 1월 31일 오전 9시 10분", "yyyy년 M월 d일 h시 m분");
		System.out.println(date2);
	}

}
