package com.engine.sevenge.utils;

/**
 * Static wrapper around android.util.Log. Enable/Disable log output using the LOG_ENABLED
 * boolean variable.
 *
 * @author kiyoqoko
 * 
 */
public class Log
{
	public static boolean LOG_ENABLED = true;

	public static void d(String tag, String msg)
	{
		if (LOG_ENABLED)
		{
			android.util.Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg)
	{
		if (LOG_ENABLED)
		{
			android.util.Log.i(tag, msg);
		}
	}

	public static void e(String tag, String msg)
	{
		if (LOG_ENABLED)
		{
			android.util.Log.e(tag, msg);
		}
	}

	public static void v(String tag, String msg)
	{
		if (LOG_ENABLED)
		{
			android.util.Log.v(tag, msg);
		}
	}

	public static void w(String tag, String msg)
	{
		if (LOG_ENABLED)
		{
			android.util.Log.w(tag, msg);
		}
	}

}