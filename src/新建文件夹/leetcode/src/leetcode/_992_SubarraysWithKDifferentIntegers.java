package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array A of positive integers, 
 * call a (contiguous, not necessarily distinct) subarray of A good 
 * if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.

 

Example 1:

Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

1;
1,2;
1,2,1;
1,2,1,2;
2,1,2;
1,2;
2;
3;





Example 2:

Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

1 2 1 3
1 3 4

1;
1,2;
1,2,1;
1,2,1,3;
2,1,3;
1,3;
3;
4;

1;
1,2;
2;
1;
1,3;
3;
4;
 

Note:

    1 <= A.length <= 20000
    1 <= A[i] <= A.length
    1 <= K <= A.length
 */
/*
思路：
转换：正好有K个不同数字的子数组的个数=最多有K个不同数字的子数组的个数-最多有K-1个不同数字的子数组的个数。

最多有K个不同数字的子数组的个数，这个问题可以使用sliding window解决。
该问题类似于“最多有K个不同数字的子数组的最大长度”。
*/


// private int atMostKDistinct(int[] A, int K) { //直接算？ No. 
//         int len = A.length;
//         int[] freq = new int[len + 1];

//         int left = 0;
//         int right = 0;
//         // [left, right) 里不同整数的个数
//         int count = 0;
//         int res = 0;
//         // [left, right) 包含不同整数的个数小于等于 K
//         while (right < len) {
//             if (freq[A[right]] == 0) {
//                 count++;
//             }
//             freq[A[right]]++;
//             right++;

//             while (count > K) {
//                 freq[A[left]]--;
//                 if (freq[A[left]] == 0) {
//                     count--;
//                 }
//                 left++;
//             }
//             // [left, right) 区间的长度就是对结果的贡献
//             res += right - left;
//         }
//         return res;
//     }

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers/solution/k-ge-bu-tong-zheng-shu-de-zi-shu-zu-by-l-ud34/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



//套用模板的版本
public class _992_SubarraysWithKDifferentIntegers {

	public static void main(String[] args){
		int[] nums=new int[]
		System.out.println(subarraysWithKDistinct(nums,1));
	}
	public int subarraysWithKDistinct(int[] nums, int K) {
		return subarrayAtMostKDistinctCount(nums,K)-subarrayAtMostKDistinctCount(nums,K-1);
	}

	//  1 2 1 3 4; K=3; 
	// 1 2; K=1;
	// 1 2; K=0;
	//1; K=1;
	//1;K=0;

	private int subarrayAtMostKDistinctCount(int[] nums,int K){
		Map<Integer,Integer> num2countMap=new HashMap<>();// in sliding window.
		
		int lo=0;
		int hi_ex=0;
		int n=nums.length;
		int res=0;
		while(hi_ex<n){//1 2 1 2 3 K=2;
			int num=nums[hi_ex];
			hi_ex++;

			//update window data
			num2countMap.put( num,(num2countMap.containsKey(num)?num2countMap.get(num):0)+1 );

			while(K<num2countMap.size()){//needs to shrink the window.
				int num_lo=nums[lo];
				lo++;

				//pudate window data
				if(num2countMap.get(num_lo)==1){
					num2countMap.remove(num_lo);
				}else{
					num2countMap.put(num_lo, num2countMap.get(num_lo)-1);
				}
			}

			//update res. 不同题目可能会在不同的位置。
			res+=hi_ex-lo;
		}

		return res;
	}
}

// class Solution_1 {
// 	public int subarraysWithKDistinct(int[] nums, int K) {
// 		return subarrayAtMostKDistinct(nums,K)-subarrayAtMostKDistinct(nums,K-1);
// 	}

// 	//  1 2 1 3 4; K=3; 
// 	// 1 2; K=1;
// 	// 1 2; K=0;
// 	private int subarrayAtMostKDistinct(int[] nums,int K){
// 		Map<Integer,Integer> num2countMap=new HashMap<>();// in sliding window.
		
// 		int lo=0;
// 		int hi=0;
// 		int n=nums.length;
// 		int res=0;
// 		while(hi<n){
// 			int num=nums[hi];
// 			num2countMap.put( num,(num2countMap.containsKey(num)?num2countMap.get(num):0)+1 );
// 			if(num2countMap.size()<=K){

// 			}else{
// 				while(lo<hi){
// 					int num_lo=nums[lo];
// 					if(num2countMap.get(num_lo)==1){
// 						num2countMap.remove(num_lo);
// 						lo++;
// 						break;
// 					}else{
// 						num2countMap.put(num_lo,num2countMap.get(num_lo)-1);
// 						lo++;
// 					}
					
// 				}
// 			}
// 			res+=hi-lo+1;
// 			hi++;
// 		}

// 		return res;
// 	}
// }


// public class _992_SubarraysWithKDifferentIntegers {
	
//     public int subarraysWithKDistinct(int[] A, int K) {
//         Map<Integer,Integer> val2countMap = new HashMap<>();//value2count map in the current sliding window.

// 		int lo=0;
// 		int hi = 0;
// 		int count = 0;

// 		while(hi < A.length){
// 			val2countMap.put(A[hi],val2countMap.getOrDefault(A[hi],0)+1);           
// 			if(val2countMap.size()>K){//previous size==k, A[hi] is a new value.
// 				val2countMap.clear();
// 				first++;
// 				second = first;
// 				continue;
// 			}

// 			if(val2countMap.size() == K){
// 				count++;
// 				second++;
// 				if(second == nums.length){
// 					val2countMap.clear();
// 					first++;
// 					second = first;
// 				}

// 				continue;
// 			}

// 			second++;

// 		}

// 		return count;
    
//     }
// }

// class Solution {
// 	public int subarraysWithKDistinct(int[] nums, int K) {
// 		Map<Integer,Integer> map = new HashMap<>();

// 		int first=0;
// 		int second = 0;
// 		int count = 0;

// 		while(second < nums.length){
// 			map.put(nums[second],map.getOrDefault(nums[second],0)+1);           
// 			if(map.size()>K){
// 				map.clear();
// 				first++;
// 				second = first;
// 				continue;
// 			}

// 			if(map.size() == K){
// 				count++;
// 				second++;
// 				if(second == nums.length){
// 					map.clear();
// 					first++;
// 					second = first;
// 				}

// 				continue;
// 			}

// 			second++;

// 		}

// 		return count;
    
// 	}
// }
