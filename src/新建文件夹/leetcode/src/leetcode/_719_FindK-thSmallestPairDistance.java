import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an integer array, return the k-th smallest distance among all the pairs. 
The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

/*Binary search for the answer. How can you check how many pairs have distance <= X?
题目中条件里写的len(nums)<=10000，也就是说数据量为10的4次方，那么时间复杂度上O(n2)基本是超时的，O(n)基本不可能，所以想到O(nlogn)，顺势也就能基本猜出用的是二分法

作者：CharlesGao
链接：https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/solution/javajian-ji-qing-xi-si-lu-shi-xian-er-fen-fa-by-ch/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        //first,find all distances
        Map<Integer,Integer> distances=new HashMap();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(distances.containsKey(Math.abs(nums[i]-nums[j]))){
                    distances.put(Math.abs(nums[i]-nums[j]),distances.get(Math.abs(nums[i]-nums[j]))+1);
                }else
                    distances.put(Math.abs(nums[i]-nums[j]),1);
            }
        }//O(n^2)
        
        //second,find the k-th smallest
        MyComparator comparator=new MyComparator();
        Queue<Integer> pq=new PriorityQueue(comparator);
        
        for(Map.Entry<Integer,Integer> e:distances.entrySet()){
            for(int i=0;i<(Integer)e.getValue();i++){
                pq.offer((Integer)e.getKey());
            } 
        }//O(n)
        
        int result=0;
        for(int i=0;i<k;i++){
            result=pq.remove();
        }
        return result;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums)
    }
}

class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer i1,Integer i2){
        return i1-i2;
    }
}


class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);//1,2,3,3,3,3;k=11

        int lo = 0;//最小距离
        int hi = nums[nums.length - 1] - nums[0];//最大距离
        while (lo < hi) {
            int mi = lo+(hi-lo +1) / 2;//中间距离 1;0
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] >= mi) 
                    left++;
                count += right - left;
            }
            //count = number of pairs with distance < mi;11;6
            if (count >= k) 
                hi = mi-1;//1
            else 
                lo = mi;//1
        }
        return lo;
    }
}

作者：LeetCode
链接：https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/solution/hei-ming-dan-zhong-de-sui-ji-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。