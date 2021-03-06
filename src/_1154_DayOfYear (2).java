package leetCode;
/*
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, 
 * return the day number of the year.

 

Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.

Example 2:

Input: date = "2019-02-10"
Output: 41

Example 3:

Input: date = "2003-03-01"
Output: 60

Example 4:

Input: date = "2004-03-01"
Output: 61

 

Constraints:

    date.length == 10
    date[4] == date[7] == '-', and all other date[i]'s are digits
    date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
 */
public class _1154_DayOfYear {
    public int dayOfYear(String date) {
    	
    	int y=Integer.parseInt(date.split("-")[0]);
    	int m=Integer.parseInt(date.split("-")[1]);
    	int d=Integer.parseInt(date.split("-")[2]);
    	
    	
    	int[] dayCountsOfM=new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
    	int res=0;
    	for(int i=1;i<m;i++) {
    		res+=dayCountsOfM[i-1];
    	}
    	res+=d;
    	return (2<m&&(y%4==0&&y%100!=0||y%400==0))?res+1:res;
    }
}
