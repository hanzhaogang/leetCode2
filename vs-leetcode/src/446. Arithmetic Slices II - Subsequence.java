import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 446. Arithmetic Slices II - Subsequence {
	
}
/* iven an integer array nums, return the number of all the arithmetic subsequences of nums.

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
The answer is guaranteed to fit in 32-bit integer.

 

Example 1:

Input: nums = [2,4,6,8,10]
Output: 7
Explanation: All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
Example 2:

Input: nums = [7,7,7,7,7]
Output: 16
Explanation: Any subsequence of this array is arithmetic.
 

Constraints:

1  <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
根据数据规模，复杂度应该是平方级。
subarray和subsequence的题目，考虑用DP。
对于一个array而言，满足条件的subsequence

主要考虑状态转移方程如何构建？思考后感觉直接用
以元素i结尾的数组包含多少个slice（记为a）作为状态不太好搞。
而用：
以元素i结尾的slice有多少个（记为b）可能会好推导一些。（注意二者的区别，a=b1、b2、b3、。。。的累加）

待求解个数=以n0结尾的slice个数+以n1结尾的slice个数+。。。+以Ni-1结尾的slice个数。
dp[i]为以Ni结尾的slice的个数
map<Integer,Integer> map中存放
*/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        List<Map<Integer,Integer>> dp=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            dp.add(new HashMap<Integer,Integer>());
        }
        for(int i=0;i<dp.size();i++){
            if(i==1){
                Map<Integer,Integer> map=dp.get(i);
                map.put(nums[i]-nums[i-1],1);
            }else if(1<i){
                Map<Integer,Integer> map=dp.get(i);
                for(int j=0;j<i;j++){
                    int diff=nums[i]-nums[j];
                    map.put(diff,map.getOrDefault(diff, 0)+1);

                    Map<Integer,Integer> preMap=dp.get(j);
                    map.put(diff,preMap.get(diff));                    
                } 

            }            
        }

        int res=0;
        for(Map<Integer,Integer> map:dp){
            if(map.isEmpty())
                continue;
            for(Map.Entry<Integer,Integer> e:map.entrySet()){
                res+=e.getValue();
            }
        }
        res-=((nums.length-1)*(nums.length-2)/2);
        return res;//return value;
    }
}


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        List<Map<Long,Integer>> dp=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            dp.add(new HashMap<Long,Integer>());
        }
        for(int i=0;i<dp.size();i++){
            if(i==1){
                Map<Long,Integer> map=dp.get(i);
                map.put((long)((long)nums[i]-(long)nums[i-1]),1);
            }else if(1<i){
                Map<Long,Integer> map=dp.get(i);
                for(int j=0;j<i;j++){
                    long diff=(long)nums[i]-(long)nums[j];
                    map.put(diff,map.getOrDefault(diff, 0)+1);

                    Map<Long,Integer> preMap=dp.get(j);
                    if(preMap.containsKey(diff))
                        map.put(diff,map.getOrDefault(diff,0)+preMap.get(diff));                    
                } 

            }            
        }

        int res=0;
        for(Map<Long,Integer> map:dp){
            if(map.isEmpty())
                continue;
            for(Map.Entry<Long,Integer> e:map.entrySet()){
                //System.out.println(e);
                if(e!=null)
                    res+=e.getValue();
            }
        }
        int n=nums.length;
        int a1 = 0, an = n - 1;
        int cnt = (a1 + an) * n / 2;
        //res-=((nums.length-1)*(nums.length-2)/2);
        return res-cnt;
    }
}