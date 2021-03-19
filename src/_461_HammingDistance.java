/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hamming-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class _461_HammingDistance {
    
}


class Solution {
    public int hammingDistance(int x, int y) {
        int dis=0;
        for(int i=0;i<32;i++){
            int bitx=x&1;
            int bity=y&1;
            if(bitx!=bity)
                dis++;
            x=x>>1;
            y=y>>1;
        }
        return dis;
    }
}