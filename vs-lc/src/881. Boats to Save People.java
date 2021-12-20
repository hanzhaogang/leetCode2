public class 881. Boats to Save People {
	
}
/* You are given an array people where people[i] is the weight of the ith person, 
and an infinite number of boats where each boat can carry a maximum weight of limit. 
Each boat carries at most two people at the same time, 
provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/boats-to-save-people
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


思路： 
船装人，先想到背包，但背包问题中背包应该是只有一个(现在是求解最少需要几艘船)。
而且，本题中限定一船最多装2人，感觉不像背包。

然后想到贪心：先给people降序排序，为了船最少，每船都有同一个limit上限，应尽量使每次船都满载或接近满载。

如果把people看做一个队列，不能直接从队头和队尾取两个数。
应该先从队头取一个值，然后找到跟它最匹配的一个值。
-----
贪心法难就难在证明啊！

证明：
首先从大到小排个序（只是为了后续的阐述）。
我觉得选择最接近limit也是对的，选择最小的也没错。
之所以觉得选择最小的不是最优的方案，是因为我们担心现在把最小的用了，后面的数据可能有没办法匹配的了。
假设真的发生了这种情况，设全部数据中的最大值为A，当前最大值为B，A >B，全部数据中的最小值是C，也就是因为之前A把C用掉了，
B在当前的数据中找不到可以匹配的了，那么难道A就能在B匹配不到的数据中找到可以匹配的吗？
当然找不到，因为A>B，B都找不到A怎么找到，所以A如果可以选也就是选择C。
所以说找最小的匹配并不会导致之后的数因为无法找到匹配而导致选择不是最优的。

之所以感觉5+2比5+1更好，是担心2找不到可以一起坐船的人。
事实上如果2可以和5(最大值)一起坐船，那2一定能找到可以一起坐船的同伴，因为其他人都比5小。
*/
class Solution {
    public int numRescueBoats(int[] people, int limit) {

    }
}