import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. 
 * Return the maximum valued number you could get.

Example 1:

Input: 2736->7766
2739->73
Output: 7236->7666
Explanation: Swap the number 2 and the number 7.

Example 2:

Input: 9973
Output: 9973
Explanation: No swap.

Note:

    The given number is in the range [0, 108]
    
    7239  9999
 */
public class _670_MaximumSwap {
    public int maximumSwap(int num) {//0,19,85,887,199
    	char[] digitChars=String.valueOf(num).toCharArray();
    	int[] lastIndexs=new int[10];
    	for(int i=0;i<digitChars.length;i++) {
    		lastIndexs[digitChars[i]-'0']=i;
    	}
    	
    	for(int i=0;i<digitChars.length;i++) {
    		char curChar=digitChars[i];
    		for(char c='9';curChar<c;c--) {
    			if(i<lastIndexs[c-'0']) {
    				char temp=digitChars[i];
    				digitChars[i]=c;
    				digitChars[lastIndexs[c]]=temp;
    				return Integer.parseInt(digitChars.toString());
    			}
    		}
    	}
    	
    	return num;
    }
}


class Solution {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}
