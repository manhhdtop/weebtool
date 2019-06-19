package org.webtool.Utils;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.webtool.cryptography.Encrypt;

public class ExtensionUtil
{
	public static String removeAccent(String s)
	{
		s = s.toLowerCase().replaceAll("đ", "d");
		return StringUtils.stripAccents(s);
	}
	
	public static String randomString(int length)
	{
		return Encrypt.getSalt(length);
	}
	
	public static String generateFileName()
	{
		int length = Constant.FILE_NAME_LENGTH;
		String timestamp = new Date().getTime() + "";
		String s = Encrypt.getSalt(length - timestamp.length());
		s += timestamp;
		return s;
	}
	
}
