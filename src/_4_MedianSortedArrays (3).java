package leetCode;
/*
 * Given two sorted arrays nums1 and nums2 of size m and n respectively.

Return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000

Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000

Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000

 

Constraints:

    nums1,length == m
    nums2,length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
 */
public class _4_MedianSortedArrays {
	public double findMedianSortedArrays(int[] A,int[] B) {
		/*
		 * [1,3,5]
		 * [2,4,6]->3.5
		 * 
		 * 1,2,3
		 * 5,6,7,8,9->5.5
		 */
		
		int numCount=A.length+B.length;
		int k=0;
		if(numCount%2!=0) {
			k=numCount/2+1;
			return getKth(A,0,A.length-1,B,0,B.length-1,k);
		}else {
			k=numCount/2+0.5;
		}
		
	}
	
	private int getKth(int[] A,int A_lo,int A_hi,int[] B,int B_lo,int B_hi,int k) {
		
	}
}
