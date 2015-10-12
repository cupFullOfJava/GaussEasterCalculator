import java.util.Scanner;

/**
 * Easter Sunday is the first Sunday after the first full moon of spring.
 * To compute the date, an algorithm by the mathematician Carl Friedrich Gauss can be used.
 * @author jeremytimothybrown
 */


/**
 * A class which implements Gauss' Easter date finder algorithm
 */

public class GaussEasterCalculator {
	
	private static int year;

	/**
	 * Allows user to enter a year, and them performs Gauss' algorithm on it to find when Easter is for the provided year.
	 * @param args Command line arguments (ignored).
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a year:");
		year = in.nextInt();
		String easterDate = doMath();
		
		
		System.out.println("In the year "+year+", Easter falls on "+easterDate+".");

	}
	
	/**
	 * Implements Gauss' algorithm
	 * @return finalDate the month and number date of Easter for year XXXX.
	 */
	public static String doMath(){
		
		String[] month = {"January", "February", "March", "April", "May", "June", "July",         
				   		"August", "September", "October", "November", "December"};
		
		int a = year%19;  				//remainder
		int b = year/100;				//quotient
		int c = year%100;				//remainder
		int d = b/4;						//quotient
		int e = b%4;						//remainder
		int g = (8*b+13)/25;				//quotient
		int h = (19*a+b-d-g+15)%30;		//remainder
		int j = c/4;						//quotient
		int k = c%4;						//remainder
		int m = (a+11*h)/319;			//quotient
		int r = (2*e+2*j-k-h+m+32)%7;	//remainder
		int n = (h-m+r+90)/25;			//quotient
		int p = (h-m+r+n+19)%32;			//remainder
		
		String corMonth = month[(int) (n-1)];
		String finalDate = corMonth+" "+p;
		
		return finalDate;
		
	}

}
