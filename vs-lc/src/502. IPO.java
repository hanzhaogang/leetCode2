import java.util.Arrays;
import java.util.PriorityQueue;

public class 502. IPO {
	
}
/* Suppose LeetCode will start its IPO soon. 
In order to sell a good price of its shares to Venture Capital, 
LeetCode would like to work on some projects to increase its capital before the IPO. 
Since it has limited resources, it can only finish at most k distinct projects before the IPO. 
Help LeetCode design the best way to maximize its total capital 
after finishing at most k distinct projects.

You are given n projects where 
the ith project has a pure profit profits[i] 
and a minimum capital of capital[i] is needed to start it.

Initially, you have w capital. 
When you finish a project, 
you will obtain its pure profit and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final capital, 
and return the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.

 

Example 1:

Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
Example 2:

Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
Output: 6
 

Constraints:

1 <= k <= 105
0 <= w <= 109
n == profits.length
n == capital.length
1 <= n <= 105
0 <= profits[i] <= 104
0 <= capital[i] <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ipo
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
根据数据规模可知，时间复杂度最多为nlgn。

首先想到递归遍历所有解空间。
但是复杂度是kn^2，会超时。

最大capital，又考虑在所有可能的解空间中做二分查找。

----
首先建立一个Map，从要求的初始capital-》能获得的最大profile的映射。

---
由lgn的复杂度不光可以联想到二分查找，还可以是堆（优先队列）。
大根堆（优先队列）可以做到每次从堆中弹出的都是当前最大的元素。


*/
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] pros=new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            pros[i][0]=profits[i];
            pros[i][1]=capital[i];
        }
        Arrays.sort(pros,(int[] pro1,int[] pro2)->{return Integer.compare(pro1[1],pro2[1]);});
        PriorityQueue<int[]> pq=new PriorityQueue<>((int[] pro1,int[] pro2)->{
            return Integer.compare(pro2[0],pro1[0]);
        });
        int j=0;
        for(int i=0;i<k;i++){
            for(;j<pros.length;j++){
                if(pros[j][1]<=w){
                    pq.offer(pros[j]);
                }else{
                    break;
                }
            }
            if(pq.isEmpty()){
                return w;
            }
            int[] polled=pq.poll();
            w+=polled[0];
        }
        return w;
    }
}
