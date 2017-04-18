package tiime;

import java.util.Objects;

//Class to construct time with hour, minute meridiam. This class allows for adding minutes to a given time.
public class MyTime {
	private int hour;
	private int min;
	private enum Meridiam {AM, PM};
	private Meridiam mer;
	
	public MyTime() {
		hour = 0;
		min = 0;
		mer = null;
	}
	
	public MyTime(int hr, int mn, Meridiam m) {
		hour = hr;
		min = mn;
		mer = m;
	}
	
	@Override
	public String toString() {
		return hour + ":" + min +  " " + mer;
	}
	
	@Override
	public boolean equals(Object O) {
		if (this == O)
	        return true;
		if (O == null)
	        return false;
		if (!(O instanceof MyTime))
			return false;
		MyTime t = (MyTime) O;

		if (hour == t.hour && min==t.min && mer.equals(t.mer))
			return true;
		return false;
	}
	
	/**	
    * @param time 12-hour time string with the format "[H]H:MM {AM|PM}"
    * @param minutes minutes to be added to time field.
    * This method adds minutes parameter value to time argument and return time in string format. 
    * eg. addMinutes("9:13 AM", 200) would return "12:33 PM".
    **/
	public String addMinutes(String time, long minutes) {
		parseTime(time);
		long minute = this.min + minutes;
		int hr = this.hour + (int)(minute/60);
		int mn = (int)(minute%60);
		
		hour = hr;
		min = mn;
		if (hr > 12) {
			//find multiple of 12 hrs time that is used in "minute' argument. This is to calculate correct 1-12 hour time and determines AM|PM 
			int multiple = hr/12; 
			
			hour = hr - 12*multiple;
			if (hour == 0)
				hour = 12;
			if(!is24hourAdvance(multiple)) {
				if (mer.equals(Meridiam.AM))
					mer = Meridiam.PM;
				else if (mer.equals(Meridiam.PM))
					mer = Meridiam.AM;
			}
		}
		return this.toString();
		
	}
	
	//Check if added time is 24 hour advance or 12 hour advance. For 24 hour AM|PM will remain the same.
	private boolean is24hourAdvance(int num) {
		if (num/4 == 0 )
			return true;
		return false;
	}
	
	/**	
    * @param time 12-hour time string with the format "[H]H:MM {AM|PM}"
    * This method breaks down the time in string format to hour, minute form and returns MyTime object.
    **/
	public void parseTime(String time) {
		if (time == null)
			throw new IllegalArgumentException("Use a valid time with format HH:MM AM|PM");
		String str1[] = time.split(":");
		hour = Integer.parseInt(str1[0].trim());
		validateHour(hour);
		
		String str2 [] = str1[1].split(" ");
		min = Integer.parseInt(str2[0].trim());
		validateMinute(min);
		
		if(str2.length == 2)
			this.mer =  getMeridiam(str2[1].trim());
		else 
			throw new IllegalArgumentException("Use AM|PM for time: " + time);
	}
	
	private void validateHour(int hour) {
		if (hour < 1 || hour > 12)
			throw new IllegalArgumentException("Hours should be between 1-12");
	}
	
	private void validateMinute(int min) {
		if (min < 0 || min > 59)
			throw new IllegalArgumentException("Minutes should be between 0-59");
	}
	
	private Meridiam getMeridiam(String m) {
		
		if ("am".equalsIgnoreCase(m) || "pm".equalsIgnoreCase(m))
			return Meridiam.valueOf(m.toUpperCase());
		else 
			throw new IllegalArgumentException("Use AM|PM");
	}

	public static void main(String[] args) {
		MyTime t = new MyTime();
		t.addMinutes("9:13 AM", 200);
		System.out.println(t);
		
		//testTime();
	}
	
	/*static void testTime() {
		MyTime t = new MyTime();
		
		if (t.addMinutes("9:13 AM", 200).equals("12:33 PM"))
				System.out.println("Test passed to add 200 minutes");
		else 
			System.out.println("Test failed to add 200 minutes");
		
		if (t.addMinutes("9:13 AM", 120).equals("11:13 AM"))
				System.out.println("Test passed to add 120 minutes");
		else 
			System.out.println("Test failed to add 120 minutes");
	} */

}
