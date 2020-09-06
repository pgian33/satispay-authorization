package it.satispay.signature.client;

import java.util.concurrent.TimeUnit;

public class GiveTimeOut {

	/**
	 *  NANOSECONDS
	 *	MICROSECONDS
	 *  MILLISECONDS
	 *  SECONDS
	 *	MINUTES
	 *  HOURS
	 * 	DAYS
	 * @param type
	 * @return
	 */
	public static TimeUnit from(String type) {
		
		switch (type) {
		case "NANOSECONDS":
			return TimeUnit.NANOSECONDS;
		case "MICROSECONDS":
			return TimeUnit.MICROSECONDS;
		case "MILLISECONDS":
			return TimeUnit.MILLISECONDS;
		case "SECONDS":
			return TimeUnit.SECONDS;
		case "MINUTES":
			return TimeUnit.MINUTES;
		case "HOURS":
			return TimeUnit.HOURS;
		case "DAYS":
			return TimeUnit.DAYS;
		default:
			return TimeUnit.SECONDS;
		}
	}
}
