/*
Given an integer array nums, 
move all 0's to the end of it 
while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class _283_moveZeros {
    
}
/*思路：
直觉应该使用双指针。
一开始p1、p2都指向0. 
p1指向非零元素序列的尾部（exclusive）,也就是零元素序列的头部（inculsive）-第一个0元素
p2指向零元素序列的尾部（exclusive），也就是待整理序列的头部（inclusive）-第一个未整理元素
用p2遍历一遍数组，
如果当前元素为0，p2++；
如果非0，把当前元素与第一个0互换，p1++，p2++；

 */
class Solution {
    public void moveZeroes(int[] nums) {
        int p1=0,p2=0;
        while(p2<nums.length&&nums[p2]!=0){
            p1++;
            p2++;
        }//both pointing to first 0
        while(p2<nums.length){
            int num=nums[p2];
            
            if(num==0){
                p2++;
            }else{
                int temp=nums[p2];
                nums[p2]=nums[p1];
                nums[p1]=temp;
                p1++;
                p2++;
            }

        }
    }
}
