package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. 
 * Return all such possible sentences.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */
public class _140_wordBreak2 {
	public static void main(String[] args) {
		String s="pineapplepenapple";
		List<String> wordDict=Arrays.asList(
				"apple", "pen", "applepen", "pine", "pineapple");
		_140_wordBreak2 solution=new _140_wordBreak2();
		System.out.println(solution.wordBreak(s,wordDict));
	}
	

	Map<Integer,List<String>> memo=new HashMap<>();
	public List<String> wordBreak(String s, List<String> wordDict) {
    	Set<String> wordSet=new HashSet<>(wordDict);
    	return bt(s,0,wordSet);
    }
    private List<String> bt(String s, int lo, Set<String> wordSet) {
    	if(memo.containsKey(lo)) {
    		return memo.get(lo);
    	}
    	
    	if(lo==s.length()) {
    		return Arrays.asList("");
    	}
    	
    	List<String> res=new ArrayList<>();
    	for(int hi=lo+1;hi<=s.length();hi++) {
    		String subStr=s.substring(lo,hi);
    		if(wordSet.contains(subStr)) {
    			List<String> list=bt(s,hi,wordSet);
    			
    			for(String str:list) {
    				res.add((subStr+" "+str).trim());
    			}
    		}
    	}
    	
    	memo.put(lo, res);
    	return res;
    }
}
