/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? 
You may assume the returned list does not count as extra space.

Example:

Input:
[-4,  -3,  -2,   -7,    8,   2,  -3,  -1]

Output:
[5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
先想一个暴力解，然后优化。
使用一个长度为n的array，记录下标对应的数字的出现次数。
遍历一遍nums数组，用array记录。
然后遍历一遍array数据，出现次数为0的元素加到结果list中。

问题的核心是复用nums数组。观察到数据中的数都是正整数，所以可以用负号来表示额外的信息！
这个信息就是下标对应的数字有没有出现过。
*/

public class _448_findAllNumberDisappearedInAnArray {
    
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int index=Math.abs(num)-1;
            int target=nums[index];
            if(0<target){
                nums[index]=0-target;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(0<nums[i]){
                list.add(i+1);
            }
        }
        return list;
    }
}