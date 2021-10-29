import java.util.ArrayList;
import java.util.List;

public class 638. Shopping Offers {
	
}
/* In LeetCode Store, there are n items to sell. 
Each item has a price. 
However, there are some special offers, 
and a special offer consists of one or more different kinds of items with a sale price.

You are given an integer array price where price[i] is the price of the ith item, 
and an integer array needs where needs[i] is the number of pieces of the ith item you want to buy.

You are also given an array special where 
special[i] is of size n + 1 where 
special[i][j] is the number of pieces of the jth item in the ith offer and 
special[i][n] (i.e., the last integer in the array) is the price of the ith offer.

Return the lowest price you have to pay for exactly certain items as given, 
where you could make optimal use of the special offers. 
You are not allowed to buy more items than you want, even if that would lower the overall price. 
You could use any of the special offers as many times as you want.

 

Example 1:

Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
Output: 14
Explanation: There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
Example 2:

Input: price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
Output: 11
Explanation: The price of A is $2, and $3 for B, $4 for C. 
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), 
and $3 for 1B, $4 for 1C. 
You cannot add more items, though only $9 for 2A ,2B and 1C.
 

Constraints:

n == price.length
n == needs.length
1 <= n <= 6
0 <= price[i] <= 10
0 <= needs[i] <= 10
1 <= special.length <= 100
special[i].length == n + 1
0 <= special[i][j] <= 50

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shopping-offers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
DP。
每一步都可以做出多种选择：每个不超过要求的special offer，或者直接用原始offer。
状态转移方程为：f（needs）=Math.min(price(special offer(i))+f(new needs(i)),......)
问题在于如何表示状态：如果用needs的每一个位共同表示，那么needs最多可以有6位，

如果降维到一维DP数组，那么数组的长度为10^6.
而special offer的长度为100.  10^8应该会超时。。

可以考虑使用预处理： 
针对第i个special offer： 123456----不可行

官方题解的复杂度：---感觉应该会超时啊
时间复杂度：O(n*k * m^n) 6*100*
其中 k 表示大礼包的数量100，m 表示每种物品的需求量的可能情况数（等于最大需求量加 11），n 表示物品数量6。
我们最多需要处理 m^nm n  个状态，每个状态需要遍历 kk 种大礼包的情况，
每个大礼包需要遍历 nn 种商品以检查大礼包是否可以购买。

*/
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	//price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
	List<List<Integer>> special_filtered=new ArrayList<>();
	for(int i=0;i<special.size();i++){
		List<Integer> s=special.get(i);
		int p=0;
		for(int j=0;j<s.size()-1;j++){
			if(needs.get(j)<s.get(j)){
				break;
			}
			p+=s.get(j)*price.get(j);
		}
		if(s.get(s.size()-1)<p){
			special_filtered.add(s);
		}
	}	

	return helper(price,special_filtered,needs);
    }
    private int helper(List<Integer> price,List<List<Integer>> special,List<Integer> needs){
	//price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
	int res=0;   
	for(int i=0;i<needs.size();i++){
		res+=needs.get(i)*price.get(i);
	}//16

	for(List<Integer> s:special){//3 0 5
		boolean b=true;
		for(int i=0;i<needs.size();i++){
			if(needs.get(i)<s.get(i)){
				b=false;
				break;
			}
		}
		if(!b){
			continue;
		}
		List<Integer> new_needs=new ArrayList<>();
		for(int i=0;i<needs.size();i++){
			new_needs.add(needs.get(i)-s.get(i));
		}
		int p=s.get(s.size()-1)+helper(price,special,new_needs);
		if(p<res){
			res=p;
		}
	}
	return res;
    }
}