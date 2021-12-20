package fb2020;
import java.util.List;

/*
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth. 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 Example 1:

Input: the list [[1,1],2,[1,1]], 
Output: 10. 
Explanation:
four 1's at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10

Example 2:

Input: the list [1,[4,[6]]], 
Output: 27. 
Explanation:
one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4 * 2 + 6 * 3 = 27

再咨询几个问题哈： 我们的首套房是打算近几年置换的，所以现在买二套就不适合拿首套房做抵押贷了吧？ 
然后如果先找中介垫资240万，全款买二套，然后再做抵押贷，那么利率就是4.35了吧？中介垫资的费用是1.8%的月利息。
如果按照30年等额本息算，每月还11947。
另外一种方案是二套按揭，25年等额本息，每月还15026。（这么算，第一年多还36948.)

第二种方案，因为利率高，我们打算10年内还清。（提前还贷。为了计算方便，第一种方案我们也提前还贷。）
问题是如果我们以每年年底30万的频率提前还贷，那第二年我们的月供是不是这么算：
贷款总额：240-30=210，贷款年限25年（不是24年对吗），那么月供是13147.
二第一种方案是210贷款年限30年，月供10454。第二年多还32316.


以此类推，第三年190万，月供12369. vs 9789 多还2580*12=30960.
第四年 160万， 22年二套：10647 vs 27年抵押贷：8401  第四年多还26952
第五年：130万  21年二套：8858vs 26年抵押贷：6964 第5年多：22728

第6年 90 
第7年 60万 19年，4314vs 24年抵押贷3343 多还1W
 
 *多还20W，
 *中介费用2万4+公司1W+公司后期成本3W，垫资4W3抵扣掉契税差额4W
 *一共节省大概14W。
 *
 */
public class _339_nested_list_weight_sum {
	int sum=0;
	int depth=0;
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
    	if(nestedList==null||nestedList.size()==0)
    		return 0;
    	
    	for(NestedInteger i:nestedList) {
    		helper(depth+1,i);
    	}
    	return sum;
    }
    
    private void helper(int depth,NestedInteger i) {
    	if(i.isInteger()) {
    		sum+=i.getInteger()*depth;
    	}else {
    		List<NestedInteger> list=i.getList();
    		for(NestedInteger j:list) {
    			helper(depth+1,j);
    		}
    	}
    }
}