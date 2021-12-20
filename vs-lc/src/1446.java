public class 1446 {
	
}
/*1446. Consecutive Characters
The power of the string is the maximum length of a non-empty substring that 
contains only one unique character.

Given a string s, return the power of s.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters. */
public int maxPower(String s) {
	int res=1;
	int count=1;
	for(int i=1;i<s.length();i++){
		if(s.charAt(i)==s.charAt(i-1)){
			count++;
		}else{
			if(res<count){
				res=count;
			}
			count=1;
		}
	}
	if(res<count)
		res=count;
	return res;
    }