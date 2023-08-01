package QLNhaSach.GUI;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester{
    private Pattern regexPattern;
    private Matcher regMatcher;
   public static boolean testngay(String ngay)
   {
	if (ngay.trim().equals(""))
		{
	    return true;
		}
	else
		{
	    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	    dateformat.setLenient(false);

	    try
	    {
	        Date javaDate = dateformat.parse(ngay); 
	    }

	    catch (ParseException ex)
	    {
	        return false;
	    }

	    return true;
		}
   }
   
   public static boolean sdt(String sdt){        
       try{
           String pattern="\\d{10}";
           if(sdt.matches(pattern)) 
        	  return true;
       }
       catch(Exception ex){            
       }
       return false;
   }
    public static void convert(
        GregorianCalendar gregorianCalendarDate)
    {
        // Creating an object of SimpleDateFormat
        SimpleDateFormat formattedDate
            = new SimpleDateFormat("dd-MMM-yyyy");
  
        // Use format() method to change the format
        // Using getTime() method,
        // this required date is passed
        // to format() method
        String dateFormatted
            = formattedDate.format(
                gregorianCalendarDate.getTime());
  
        // Displaying grogorian date ia SimpleDateFormat
        System.out.print("SimpleDateFormat: "
                         + dateFormatted);
    }
   public boolean testemail(String email) 
    {
        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        regMatcher   = regexPattern.matcher(email);
        if(regMatcher.matches()) {
            return true;
        } 
        else 
        {
            return false;
        }
    }
}
