import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a string s and a non-empty string p, find all the start indices of p’s anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

    1
    2
    3
    4
    5
    6
    7
    8
    9

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class _438_FindAllAnagramsinaString {
	public static void main(String[] args) {
		_438_FindAllAnagramsinaString solution= new _438_FindAllAnagramsinaString();
		String s="cbaebabacd";
	    String p="abc";
		solution.find(s, p);
	}
	
	
	List<Integer> find(String s,String p){
		//s: "cbaebabacd" p: "abc"
		int[] pCharCounts=new int[26];
		for(int i=0;i<p.length();i++) {
			pCharCounts[p.charAt(i)-'a']++;
		} // 1 1 1 
		
		List<Integer> res=new ArrayList<>();
		int[] sCharCounts=new int[26];
		int lo=0;
		int hi=0;
		for(;hi<Math.min(s.length(), p.length());hi++) {
			sCharCounts[s.charAt(hi)-'a']++;
		}//1 1 1
		hi--;
		
		while(hi+1<s.length()) {// 2 
			if(Arrays.equals(pCharCounts, sCharCounts))
				res.add(lo);// 0 
			
			sCharCounts[s.charAt(lo)-'a']--;  // 1 1 
			lo++;// 1 
			hi++;// 3
			sCharCounts[s.charAt(hi)-'a']++; // a b e
		}
		if(Arrays.equals(pCharCounts, sCharCounts))
			res.add(lo);
		
		return res; 
	}
}
//故人村头坟前纸。
