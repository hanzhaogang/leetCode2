package leetCode;
/*
 * Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.

 

Example 1:

Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1

Example 2:

Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15

 

Constraints:

    The given dates are valid dates between the years 1971 and 2100.
 */
public class _1360_datesBetweenTwoDays {
	public static void main(String[] args) {
		String date1=
	}
	
   	String beginning="1970-00-00";
    public int daysBetweenDates(String date1, String date2) {
    	return Math.abs(getDays(date1)-getDays(date2));
    }
    private int[] parseString(String str) {
    	int[] res=new int[3];
    	String[] strArray=str.split("-");
    	for(int i=0;i<strArray.length;i++) {
    		res[i]=Integer.parseInt(strArray[i]);
    	}
    	return res;
    }
    private int getDays(String date) {
    	int res=0;
    	int[] beginInts=parseString(beginning);
    	int[] dateInts=parseString(date);
    	
    	int beginYear=beginInts[0];
    	int curYear=dateInts[0];
    	for(int y=beginYear;y<curYear;y++) {
    		if(yunYear(y)) {
    			res+=366;
    		}else {
    			res+=365;
    		}
    	}
    	
    	int[] day4Mon=new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
    	int curMon=dateInts[1];
    	for(int m=1;m<curMon;m++) {
    		res+=day4Mon[m-1];
    		if(m==2&&yunYear(curYear)) {
    			res++;
    		}
    	}

    	
    	res+=dateInts[2];
    	return res;
    }
    private boolean yunYear(int year) {
    	if(year%100==0&&year%400==0) {
    		return true;
    	}else if(year%4==0&&year%100!=0) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
