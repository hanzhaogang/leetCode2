package leetCode;
/*
 * Given two non-negative integers num1 and num2 represented as string, 
 * return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class _415_addStrings {
    public String addStrings(String num1, String num2) {//911,99
    	//408,5
    	int l1=num1.length();//3
    	int l2=num2.length();//1
    	
    	StringBuilder sb=new StringBuilder();
    	int addition=0;
    	for(int i=0;i<Math.max(l1, l2);i++) {//0 1 2
    		int n1=i<l1?(num1.charAt(l1-1-i)-'0'):0;//8
    		int n2=i<l2?(num2.charAt(l2-1-i)-'0'):0;//5
    		int n=n1+n2+addition;//13
    		if(n<10) {
    			sb.insert(0,n);
    			addition=0;
    		}else {
    			sb.insert(0,n%10);//3
    			addition=n/10;//1
    		}
    	}
    	if(addition!=0) {
    		sb.insert(0, addition);
    	}
    	return sb.toString();
    }
}
