package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * You are given an m * n matrix, mat, and an integer k, 
 * which has its rows sorted in non-decreasing order.

You are allowed to choose exactly 1 element from each row to form an array. 
Return the Kth smallest array sum among all possible arrays.

 

Example 1:

Input: mat = [
[1,3,11],
[2,4,6]], k = 5

Output: 7
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.  

Example 2:

Input: mat = [
[1,3,11],
[2,4,6]], k = 9
Output: 17

Example 3:

Input: mat = [
[1,10,10],
[1,4,5],
[2,3,6]], k = 7
Output: 9
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.  

Example 4:

Input: mat = [[1,1,10],[2,2,9]], k = 7
Output: 12

 

Constraints:

    m == mat.length
    n == mat.length[i]
    1 <= m, n <= 40
    1 <= k <= min(200, n ^ m)
    1 <= mat[i][j] <= 5000
    mat[i] is a non decreasing array.
\



Save all visited sums and corresponding indexes in a priority queue. 
Then, once you pop the smallest sum so far, 
you can quickly identify the next m candidates for smallest sum 
by incrementing each row index by 1.
 */
public class _1439_kthSmallestSum {
    public int kthSmallest(int[][] mat, int k) {
        int matLen=mat.length;//2
        Set<List<Integer>> visited=new HashSet<>();
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((l1,l2)->{
            int sum1=0;
            for(int i=0;i<l1.size();i++){
                sum1+=mat[i][l1.get(i)];
            }
            int sum2=0;
            for(int i=0;i<l2.size();i++){
                sum2+=mat[i][l2.get(i)];
            }

            return Integer.compare(sum1, sum2);
        });
        List<Integer> indexList=new ArrayList<>();
        for(int i=0;i<matLen;i++){
            indexList.add(0);
        }

        pq.offer(indexList);
        visited.add(indexList);
        int res=0;
        for(int i=0;i<k;i++){
            List<Integer> curList=pq.poll();
            
            if(i==k-1){
                for(int j=0;j<matLen;j++){
                    res+=mat[j][curList.get(j)];
                }
                return res;
            }
            for(int j=0;j<matLen;j++){
                if(curList.get(j)<mat[0].length-1){
                    List<Integer> newList=new ArrayList<>(curList);
                    newList.set(j,curList.get(j)+1);
                    if(!visited.contains(newList)){
                        visited.add(newList);
                        pq.offer(newList);
                    }
                    
                }
                
            }
        }
        return res;
    }
}