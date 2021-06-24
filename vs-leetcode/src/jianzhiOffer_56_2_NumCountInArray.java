public class jianzhiOffer_56_2_NumCountInArray {
    
}

class Solution {
    public int singleNumber(int[] nums) {

    }
}

/*剑指 Offer 56 - II. 数组中数字出现的次数 II
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

 

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1
 

限制：

1 <= nums.length <= 10000
1 <= nums[i] < 2^31
 

思路：
1. hashmap统计每个数字的出现次数 时间；
2. hashset
3. 如果其他数字都是出现2次，只有一个数字出现1次，那么，用xor操作可以解决。
因为n xor n = 0; n xor 0 = n;


leetcode 官方思路：
如下图所示，考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 3 的倍数。
因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。

[3,3,3,5]

                    3->0 0 1 1
                    3->0 0 1 1
                    3->0 0 1 1
                    5->0 1 1 1
每个位上1出现的次数      0 1 4 4
对3取余                 0 1 1 1 （5）
*/