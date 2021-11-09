package leetCode;

import java.util.Arrays;

public class _937_reorderDataInLogFiles {
	/*
	 * You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  
Then, either:

    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.

We will call these two varieties of logs letter-logs and digit-logs.  
It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that 
1.all of the letter-logs come before any digit-log.  
2.The letter-logs are ordered lexicographically ignoring identifier, 
3.with the identifier used in case of ties.  
4.The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: logs = [
"dig1 8 1 5 1",
"let1 art can",
"dig2 3 6",
"let2 own kit dig",
"let3 art zero"]
Output: [
"let1 art can",
"let3 art zero",
"let2 own kit dig",
"dig1 8 1 5 1",
"dig2 3 6"]

 

Constraints:

    0 <= logs.length <= 100
    3 <= logs[i].length <= 100
    logs[i] is guaranteed to have an identifier, and a word after the identifier.
	 */
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs,(log1,log2)->{
			String[] log1Eles=log1.split(" ",2);
			String[] log2Eles=log2.split(" ",2);
			boolean d1=Character.isDigit(log1Eles[1].charAt(0));
			boolean d2=Character.isDigit(log2Eles[1].charAt(0));
			if(!d1&&d2) {
				return -1;//-1 means log1 is before log2.
			}else if(d1&&!d2) {
				return 1;
			}else if(!d1&&!d2) {
				int i=log1Eles[1].compareTo(log2Eles[1]);
				if(i!=0)
					return i;
				else {
					return log1Eles[0].compareTo(log2Eles[0]);
				}
			}
			
			return 0;
		});
		
		return logs;
    }
	
}
