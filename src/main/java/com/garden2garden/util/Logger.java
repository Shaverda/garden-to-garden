package com.garden2garden.util;

/**
 * Placeholder logging class that just outputs to stdout, to use until actually logging is inserted.
 */
public class Logger
{
	public enum LogLevel
	{
		DEBUG,
		INFO,
		LOG,
		ERROR,
		FATAL;

		@Override
		public String toString()
		{
			return super.toString() + ": ";
		}
	}

	public static void log(String message)
	{
		log(message, LogLevel.LOG);
	}

	public static void debug(String message)
	{
		log(message, LogLevel.DEBUG);
	}

	public static void info(String message)
	{
		log(message, LogLevel.INFO);
	}

	public static void error(String message)
	{
		log(message, LogLevel.ERROR);
	}

	public static void fatal(String message)
	{
		log(message, LogLevel.FATAL);
	}

	private static void log(String message, LogLevel level)
	{
		System.out.println(level.toString() + message);
	}
}
