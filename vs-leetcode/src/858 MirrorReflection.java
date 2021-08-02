public class 858 MirrorReflection {
	
}
/* There is a special square room with mirrors on each of the four walls.  
Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.

The square room has walls of length p, 
and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.

Return the number of the receptor that the ray meets first.  
(It is guaranteed that the ray will meet a receptor eventually.)

 

Example 1:

Input: p = 2, q = 1
Output: 2
Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.

Note:

1 <= p <= 1000
0 <= q <= p

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/mirror-reflection
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 


思路： 
数据规模可知复杂度为n^2
一般这种应用题目需要抽象成它所对应的本质问题。

---
数学问题常常要举例子找出其规律。

---
理解了题意，也有思路，但是不知道怎么去落实到代码。

---问题在于还没有把应用题抽象成数学问题。这道题对应的数学问题是求p、q的最小公倍数，然后看最小公倍数是p的奇数倍、还是偶数倍
*/

class Solution {
    public int mirrorReflection(int p, int q) {
        p*q
    }
}