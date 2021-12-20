public class 541. Reverse String II {
	
}
/* Given a string s and an integer k, 
reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-string-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
搞3个指针，初始情况下，p1指向第一个元素，p2指向第k个元素，p3指向第2k个元素。
StringBuilder sb=new StringBuilder(s);
while(p1!=null&&p2!==null&&p3!=null){
	int lo=p1;
	int hi=p2;
	while(lo<hi){
		char temp=sb.charAt(lo);
		sb.setChar(lo,sb.charAt(hi));
		sb.setChar(hi,temp);
		lo++;
		hi--;
	}

	p1=p2;
	for(int i=0;i<k;i++){
		if(p2!=null)
			p2=p2.next;
		else
			break;
	}
	if(p2==null){
		p3==null;
	}else{

	}
}

如果p2为空，翻转p1、p2之间的元素；
如果p2不为空，p3为空，翻转p1、p2之间的元素；

----
没有仔细审题。题目是string不是链表，所以不用移动指针。
*/
class Solution {
    public String reverseStr(String s, int k) {
	int p=0;
	StringBuilder sb=new StringBuilder(s);
	while(p<s.length()&&(p+2*k)<s.length()){
		int lo=p;
		int hi=p+k-1;
		while(lo<hi){
			char temp=s.charAt(lo);
			sb.setCharAt(lo, s.charAt(hi));
			sb.setCharAt(hi, temp);
			lo++;
			hi--;
		}
		p+=2*k;
	}
	if(p<s.length()){
		int lo=p;
		int hi=Math.min(s.length(),lo+k)-1;
		while(lo<hi){
			char temp=s.charAt(lo);
			sb.setCharAt(lo, s.charAt(hi));
			sb.setCharAt(hi, temp);
			lo++;
			hi--;
		}
	}
	return sb.toString();
    }
}
