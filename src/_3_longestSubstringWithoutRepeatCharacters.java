package leetCode;

import java.util.HashMap;
import java.util.Map;

/*
 *Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *  
 *pwwkew-> wke-> 3
* pkwwkew-> 
* pkwwker-> 
* pkwwwker
* wwwwwww
*/

public class _3_longestSubstringWithoutRepeatCharacters {//au
	public int lengthOfLongestSubstring(String s){
		if(s.length()==0)
			return 0;
		
		Map<Character,Integer> char2Index=new HashMap<>();
		int lo=0;
		int hi=0;
		int maxLen=1;
		while(hi<s.length()) {
			char c=s.charAt(hi);
			if(!char2Index.isEmpty()&&char2Index.containsKey(c)&&lo<=char2Index.get(c)) {
				int len=hi-lo;
				if(maxLen<len)
					maxLen=len;
				lo=char2Index.get(c)+1;
			}
			char2Index.put(c, hi);
			hi++;
		}
		
		if(maxLen<hi-lo)
			maxLen=hi-lo;
		
		return maxLen;
	}
}
