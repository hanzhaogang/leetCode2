package leetcode;
/*
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

	这种写法比较繁琐。
 */
public class _415_AddStrings {
    public String addStrings(String num1, String num2) {//0,0; 12,98
    	int additional=0;
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<Math.min(num1.length(), num2.length());i++) {
    		int curRes=additional+(num1.charAt(num1.length()-1-i)-'0')+(num2.charAt(num2.length()-1-i)-'0');
    		
    		additional=curRes%10;
    		sb.append(curRes/10);
    	}
    	
    	for(int i=Math.min(num1.length(), num2.length());i<num1.length();i++) {
    		int curRes=additional+num1.charAt(num1.length()-1-i)-'0';
    		additional=curRes%10;
    		sb.append(curRes/10);
    	}
    	
    	for(int i=Math.min(num1.length(), num2.length());i<num2.length();i++) {
    		int curRes=additional+num1.charAt(num1.length()-1-i)-'0';
    		additional=curRes%10;
    		sb.append(curRes/10);
    	}
    	
    	if(additional==1) {
    		sb.append(additional);
    	}
    	return sb.reverse().toString();
    }
}
