public class LC0007_ReverseInteger {
	public int reverse(int x) {
        String minString=Integer.toString(0-(int)Math.pow(2,31));
        String maxString=Integer.toString((int)Math.pow(2,31)-1);
       
        StringBuilder sb=new StringBuilder(String.valueOf(x)).reverse();
        //handle leading 0
        String str=sb.toString().replaceFirst("^0+(?!$)", "");
        //handle ending -
        if(str.charAt(str.length()-1)=='-')
        	str="-"+str.substring(0,str.length()-1);
        
        if(str.charAt(0)=='-'&&(str.length()==minString.length()&&0<str.compareTo(minString) ||
        		minString.length()<str.length()) ||
        		str.charAt(0)!='-'&&(str.length()==maxString.length()&&0<str.compareTo(maxString)||
        		maxString.length()<str.length())){
            return 0;
        }else{
            return Integer.parseInt(str);
        }
    }
}
/*
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers 
within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 
when the reversed integer overflows.
 */
