package edu.utils.dao.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


 
public class StringUtils {

    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    public static void main(String[] args) {
    	String aString = "just do it!\n dfd  	f";
        System.out.println(StringUtils.replaceBlank(aString));
        System.out.println(aString.replaceAll("\\s+", " "));
        
    }
}
