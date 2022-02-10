package test.selenium;

public class PrintDatesDynamic {

	public static void main(String[] args) {

		String date = "31st Jan 2023";
		String dates[]=date.split(" ");
		String dd = dates[0].replaceAll("[^\\d]", "");;
		String mm = dates[1];
		String yy = dates[2];
		if(checkDate(dd,mm,yy)) {
			System.out.print("Previous Day: ");
			System.out.println(previousDate(dd,mm,yy));
			System.out.print("Today : ");
			System.out.println(date);
			System.out.print("Next Day : ");
			System.out.println(nextDate(dd, mm, yy));
		}
		else {
			System.out.print(date+" is not a valid date");
		}

	}

	private static String previousDate(String day, String mm, String yy) {
		day =DateDigits(day);
		String pdate ="";

		if(mm.equals("Jan") && day.equals("01")) {
			mm = "Dec";
			day = "31";
			yy = String.valueOf((Integer.valueOf(yy))-1);
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}
		else if(mm.equals("Feb") && (day.equals("01"))) {
			mm = "Jan";
			day = "31";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Mar") && day.equals("01")) {
			mm = "Feb";
			day = "28";
			pdate = (adjustDate(DateDigits(leapYearHandle(yy)))+" "+mm+" "+yy);
		}

		else if(mm.equals("Apr") && day.equals("01")) {
			mm = "Mar";
			day = "31";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("May") && day.equals("01")) {
			mm = "Apr";
			day = "30";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Jun") && day.equals("01")) {
			mm = "May";
			day = "31";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Jul") && day.equals("01")) {
			mm = "Jun";
			day = "30";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Aug") && day.equals("01")) {
			mm = "Jul";
			day = "31";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Sep") && day.equals("01")) {
			mm = "Aug";
			day = "31";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Oct") && day.equals("01")) {
			mm = "Sep";
			day = "30";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Nov") && day.equals("01")) {
			mm = "Oct";
			day = "31";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Dec") && day.equals("01")) {
			mm = "Nov";
			day = "30";
			pdate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}
		else {

			//String d = day.replaceAll("[^\\d]", "");
			String pday=day.replaceAll("\\d\\d", String.valueOf((Integer.valueOf(day))-1));
			pdate = (adjustDate(DateDigits(pday))+" "+mm+" "+yy);

		}

		return pdate;

	}


	private static String nextDate(String day, String mm, String yy) {
		day =DateDigits(day);
		String ndate ="";

		if(mm.equals("Jan") && day.equals("31")) {
			mm = "Feb";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}
		else if(mm.equals("Feb") && day.equals("29") && (isLeapYear(yy))) {
			mm = "Mar";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Feb") && day.equals("28") && !(isLeapYear(yy))) {
			mm = "Mar";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Mar") && day.equals("31")) {
			mm = "Apr";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("May") && day.equals("30")) {
			mm = "Jun";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Jun") && day.equals("30")) {
			mm = "Jul";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Jul") && day.equals("31")) {
			mm = "Aug";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Aug") && day.equals("31")) {
			mm = "Sep";
			day = "30";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Sep") && day.equals("30")) {
			mm = "Oct";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Oct") && day.equals("31")) {
			mm = "Nov";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Nov") && day.equals("30")) {
			mm = "Dec";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+yy);
		}

		else if(mm.equals("Dec") && day.equals("31")) {
			mm = "Jan";
			day = "01";
			ndate = (adjustDate(DateDigits(day))+" "+mm+" "+String.valueOf((Integer.valueOf(yy))+1));
		}
		else {

			String nday=day.replaceAll("\\d\\d", String.valueOf((Integer.valueOf(day))+1));
			ndate = (adjustDate(DateDigits(nday))+" "+mm+" "+yy);

		}

		return ndate;

	}

	private static String DateDigits(String day) {
		if(day.length()==1) {
			day="0"+day;
		}

		return day;
	}

	private static String leapYearHandle(String yy) {

		int year = Integer.valueOf(yy);
		if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)) {
			return String.valueOf(29);
		}
		else {
			return String.valueOf(28);
		}
	}

	private static boolean isLeapYear(String yy) {
		int year = Integer.valueOf(yy);
		if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)) {
			return true;
		}
		else {
			return false;
		}
	}

	private static String adjustDate(String day) {
		int d = Integer.valueOf(day);
		String suff="";
		if(d<4 || d>=20) {
			d = Integer.valueOf(day.substring(1));
			if(d==0) {
				suff="th";
			}
			if(d==1) {
				suff="st";	
			}
			if(d==2) {
				suff = "nd";
			}
			if(d==3) {
				suff = "rd";
			}
			if(d>3) {
				suff="th";
			}
		}
		else{
			suff = "th";
		}

		return day+suff;
	}

	private static boolean checkDate(String day, String mm, String yy) {

		day =DateDigits(day);
		boolean flag=true;
		if(mm.equals("Feb") && Integer.valueOf(day)>28 && !isLeapYear(yy)
				||mm.equals("Feb") && Integer.valueOf(day)>29 && isLeapYear(yy)
				||((mm.equals("Jan")||mm.equals("Mar")||mm.equals("May")||mm.equals("Jul")
						||mm.equals("Aug")||mm.equals("Oct")||mm.equals("Dec")) && Integer.valueOf(day)>31)
				||((mm.equals("Apr")||mm.equals("Jun")||mm.equals("Sep")||mm.equals("Nov")) && Integer.valueOf(day)>31)
				) {
			flag = false;;
		}
		return flag;
	}

}
