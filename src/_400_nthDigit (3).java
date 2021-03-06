package leetCode;
/*
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).

Example 1:

Input:
3

Output:
3

Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

10;180;2700;36000;450000;
10*1;90*2;900*3;9000*4;90000*5;9_000_000_000*10;
0-9,10-99,100-999,1000-9999,10000-99999,1_000_000_000-9999999999,
 */

public class _400_nthDigit {
    public int findNthDigit(int n) {//1;9;11
    	if(n<10) {
    		return n;
    	}
    	
    	int k=1;
    	while(0<n) {
    		n=n-9*k*(int)Math.pow(10, k-1);//2,-7
    		k++;//2;3
    	}//n=0;k=2;
    	n=n+9*k*(int)Math.pow(10, k-1);//1;9;2
    	k--;//1;2
    	
    	int start=(int)Math.pow(10, k-1);//1;10
    	int num=(n-1)/k;//1;1
    	int digit=(n-1)%k;//0;
    	String str=String.valueOf(num+start);
    	return str.charAt(digit)-'0';
    }
}
