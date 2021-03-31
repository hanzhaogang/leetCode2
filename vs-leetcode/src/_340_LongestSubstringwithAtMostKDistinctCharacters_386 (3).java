package leetCode;

import java.util.HashMap;
import java.util.Map;

/*

Given a string S, 
find the length of the longest substring T 
that contains at most k distinct characters.

Example 1:

Input: S = "eceba" and k = 3
Output: 4
Explanation: T = "eceb"

Example 2:

Input: S = "WORLD" and k = 4
Output: 4
Explanation: T = "WORL" or "ORLD"

Challenge

O(n) time

 */
public class _340_LongestSubstringwithAtMostKDistinctCharacters_386 {
	public static void main(String[] args) {
		int k=16;
		String s="eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";
		_340_LongestSubstringwithAtMostKDistinctCharacters_386 solution=
				new _340_LongestSubstringwithAtMostKDistinctCharacters_386();
		System.out.println(solution.lengthOfLongestSubstringKDistinct(s, k));
	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character,Integer> char2index=new HashMap<>();
		int maxLen=0;//""
		for(int lo=0,hi=0;hi<s.length();hi++) {
			char2index.put(s.charAt(hi), hi);//aaaaaaab
			if(k<char2index.size()) {
				for(;lo<hi;lo++) {
					int index=char2index.get(s.charAt(lo));
					if(index==lo) {
						char2index.remove(s.charAt(lo));
						break;
					}
				}
				
				lo++;
			}
			
			if(maxLen<hi-lo+1)
				maxLen=hi-lo+1;
		}
		
		return maxLen;
	}
}
