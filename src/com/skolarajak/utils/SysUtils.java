package com.skolarajak.utils;

import com.sun.istack.internal.logging.Logger;

public class SysUtils {
	private final static Logger LOG = Logger.getLogger(SysUtils.class.getName());
	public static long printDuration(long startTime) {
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		// System.err.println("----duration---->" + duration);
		return duration;
	}
}
 