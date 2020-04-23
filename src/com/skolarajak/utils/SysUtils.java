package com.skolarajak.utils;

public class SysUtils {
	public static long printDuration(long startTime) {
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.err.println("----duration---->" + duration);
		return duration;
	}
}
