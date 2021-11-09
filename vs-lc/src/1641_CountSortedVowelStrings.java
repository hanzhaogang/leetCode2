/* Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

5 4 3 2 1

Input: n = 2
Output: 15=5+4+3+2+1=5*(5+1)/2
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

5 4 3 2 1 
4 3 2 1 
3 2 1
2 1 
1


Example 3:

Input: n = 33
Output: 66045
a...a,...,u...u 

Constraints:

1 <= n <= 50 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

For each character, its possible values will depend on the value of its previous character, because it needs to be not smaller than it.

Think backtracking. Build a recursive function count(n, last_character) that counts the number of valid strings of length n and whose first characters are not less than last_character.

In this recursive function, iterate on the possible characters for the first character, 
which will be all the vowels not less than last_character, and for each possible value c, increase the answer by count(n-1, c).*/

class Solution {
    public int countVowelStrings(int n) {
	if(n==1){
	    return 5; 
	}

	return 
	    
    }
}