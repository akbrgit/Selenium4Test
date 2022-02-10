package test.selenium;

public class PrintDatesWithoutLib {

	public static void main(String[] args) {
		
		String date = "12th March 1983";
		String dates[]=date.split(" ");
		String dd = dates[0];
		String mm = dates[1];
		String yy = dates[2];
		String d = dd.replaceAll("[^\\d]", "");
		String nday=d;
		String pday=d;
		nday = dd.replaceAll("\\d\\d", String.valueOf((Integer.valueOf(d))+1));
		pday=dd.replaceAll("\\d\\d", String.valueOf((Integer.valueOf(d))-1));
		
		System.out.println(nday+" "+mm+" "+yy);
		System.out.println(pday+" "+mm+" "+yy);
		}

}
