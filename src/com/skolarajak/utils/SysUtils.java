package com.skolarajak.utils;
import java.util.logging.Logger;


public class SysUtils {
	private final static Logger LOG = Logger.getLogger(SysUtils.class.getName());
	public static long printDuration(long startTime) {
		LOG.fine("start time: " + startTime);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		// System.err.println("----duration---->" + duration);
		LOG.info("----duration---->" + duration);
		return duration;
	}
}
 