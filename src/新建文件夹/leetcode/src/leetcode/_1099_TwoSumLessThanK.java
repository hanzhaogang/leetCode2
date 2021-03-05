package leetcode;

import java.util.Arrays;

public class _1099_TwoSumLessThanK {
	/* * LeetCode 1099. Two Sum Less Than K
	Given an array A of integers and integer K, 
	return the maximum S such that there exists i < j with A[i] + A[j] = S and S < K. 
	If no i, j exist satisfying this equation, return -1.

	Example 1:

	Input: A = [34,23,1,24,75,33,54,8], K = 60 
	Output: 58 Explanation: We can use 34 and 24 to sum 58 which is less than 60. 

	Example 2:

	Input: A = [10,20,30], K = 15 Output: -1 Explanation: In this case it‘s not possible to get a pair sum less that 15.

	Note:

	    1 <= A.length <= 100
	    1 <= A[i] <= 1000
	    1 <= K <= 2000

	 */
		public static void main(String[] args) {
			int[] A= {34,23,1,24,75,33,54,8};
			int K=60;
			_1099_TwoSumLessThanK c=new _1099_TwoSumLessThanK();
			System.out.println(c.twoSumLessThanK(A,K));
			
			int[] B= {10,20,30};
			K=15;
			System.out.println(c.twoSumLessThanK(B,K));
		}
		
		public int twoSumLessThanK(int[] A, int K) {
			/*[1,8,23,24,33,34,54,75]
			 * K=60
			 */
			Arrays.sort(A);
			
			int res=-1;
			
			int lo=0;
			int hi=A.length-1;
			while(lo<hi) {
				int sum=A[lo]+A[hi];
				if(sum<K) {
					if(res<sum) {
						res=sum;
					}
					lo++;
				}else {
					hi--;
				}
			}
			
			return res;
		}
}
