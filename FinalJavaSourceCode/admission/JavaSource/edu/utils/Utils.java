package edu.utils;

public class Utils {
	public static int stringToInt(String str, int def) {
		int intRet = def;
		try {
			if (str == null || str.trim().equals(""))
				str = def + "";
			intRet = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return intRet;
	}
}
