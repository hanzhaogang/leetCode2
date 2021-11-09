import java.util.Collections;
import java.util.List;

public class 524. Longest Word in Dictionary through Deleting {
	
}
/* Given a string s and a string array dictionary, 
return the longest string in the dictionary that 
can be formed by deleting some of the given string characters. 
If there is more than one possible result, 
return the longest word with the smallest lexicographical order. 
If there is no possible result, return the empty string.

 

Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
Example 2:

Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
 

Constraints:

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s and dictionary[i] consist of lowercase English letters.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
	Collections.sort(dictionary,(String s1,String s2)->{
		if(s1.length()!=s2.length()){
			return s2.length()-s1.length();
		}else{
			return s1.compareTo(s2);
		}
	});

	for(String word:dictionary){
		int ps=0;
		int pw=0;
		while(ps<s.length()&&pw<word.length()){
			if(s.charAt(ps)==word.charAt(pw)){
				if(pw==word.length()-1){
					return word;
				}else{
					ps++;
					pw++;
				}	
			}else{
				ps++;
			}
		}
	}

	return "";
    }
}