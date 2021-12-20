public class 1109. Corporate Flight Bookings {
	
}
/* There are n flights that are labeled from 1 to n.

You are given an array of flight bookings bookings, 
where bookings[i] = [firsti, lasti, seatsi] 
represents a booking for flights firsti through lasti (inclusive) 
with seatsi seats reserved for each flight in the range.

Return an array answer of length n, 
where answer[i] is the total number of seats reserved for flight i.

 

Example 1:

Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]
Explanation:
Flight labels:        1   2   3   4   5
Booking 1 reserved:  10  10
Booking 2 reserved:      20  20
Booking 3 reserved:      25  25  25  25
Total seats:         10  55  45  25  25
Hence, answer = [10,55,45,25,25]
Example 2:

Input: bookings = [[1,2,10],[2,2,15]], n = 2
Output: [10,25]
Explanation:
Flight labels:        1   2
Booking 1 reserved:  10  10
Booking 2 reserved:      15
Total seats:         10  25
Hence, answer = [10,25]

 

Constraints:

1 <= n <= 2 * 104
1 <= bookings.length <= 2 * 104
bookings[i].length == 3
1 <= firsti <= lasti <= n
1 <= seatsi <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/corporate-flight-bookings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
首先为1-n个航班建立一个计数用数组ans
然后遍历flights数组，为每个航班更新计数。
最后输出ans
复杂度： O(flgihts.length*n)，会超时。

考虑上述直接求解的思路，没有可以优化的空间。


需要想办法降低复杂度，而题意中看不到lgn的迹象，所以考虑用线性时间复杂度的算法解决。

后来在纸上画图的时候，灵光一现，感觉很像扫描线算法。
后来看了一下题解，发现我用扫描线方法构造出来的数组，就是差分数组。
查分数组的preSum数组，就是原数组。
*/
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] cfArr=new int[n+2];
        for(int i=0;i<bookings.length;i++){
            int[] booking=bookings[i];
            int lo=booking[0];
            int hi=booking[1];
            int val=booking[2];
            cfArr[lo]+=val;
            cfArr[hi+1]-=val;
        }
        int[] ans=new int[n];
        for(int i=0;i<ans.length;i++){
            if(i==0)
                ans[i]=cfArr[1];
            else{
                ans[i]=ans[i-1]+cfArr[i+1];
            }
        }
        return ans;
    }
}