import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 345. Reverse Vowels of a String {
	
}
/* Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
根据数据规模可知是线性时间复杂度。
双指针，分别从两头往中间逼近。*/
class Solution {
    public String reverseVowels(String s) {
	Set<Character> vowelsSet=new HashSet<>();
	vowelsSet.addAll(Arrays.asList('a','A','e','E','i','I','o','O','u','U'));
	int lo=0;
	int hi=s.length()-1;
	StringBuilder sb=new StringBuilder(s);
	while(lo<hi){
		if(!vowelsSet.contains(s.charAt(lo))){
			lo++;
		}else if(!vowelsSet.contains(s.charAt(hi))){
			hi--;
		}else{
			char temp=sb.charAt(lo);
			sb.setCharAt(lo, sb.charAt(hi));
			sb.setCharAt(hi, temp);
			lo++;
			hi--;
		}
	}
	return sb.toString();
    }
}