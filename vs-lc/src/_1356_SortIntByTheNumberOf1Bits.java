package leetCode;

import java.util.Arrays;

/*
 * Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the sorted array.

 

Example 1:

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 2:

Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.

Example 3:

Input: arr = [10000,10000]
Output: [10000,10000]

Example 4:

Input: arr = [2,3,5,7,11,13,17,19]
Output: [2,3,5,17,7,11,13,19]

Example 5:

Input: arr = [10,100,1000,10000]
Output: [10,100,10000,1000]

 

Constraints:

    1 <= arr.length <= 500
    0 <= arr[i] <= 10^4
 */
public class _1356_SortIntByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
    	int[][] numCountArr=new int[arr.length][2];
    	for(int i=0;i<arr.length;i++) {
    		numCountArr[i]=new int[] {arr[i],bit1Count(arr[i])};
    	}
    	Arrays.sort(numCountArr,(a1,a2)->{
    		if(a1[1]==a2[1]) {
    			return Integer.compare(a1[0], a2[0]);
    		}else {
    			return Integer.compare(a1[1], a2[1]);
    		}
    	});
    	
    	int[] res=new int[arr.length];
    	for(int i=0;i<res.length;i++) {
    		res[i]=numCountArr[i][0];
    	}
    	
    	return res;
    }
    
    public int bit1Count(int n) {
    	int c=0;
    	while(n!=0) {
    		int bit=n%2;
    		if(bit==1)
    			c++;
    		n=n/2;
    	}
    	return c;
    }
}
